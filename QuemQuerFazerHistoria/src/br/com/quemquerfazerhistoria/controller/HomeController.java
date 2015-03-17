package br.com.quemquerfazerhistoria.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.quemquerfazerhistoria.dao.HistoriaGeradaDAO;
import br.com.quemquerfazerhistoria.dao.Nivel1DAO;
import br.com.quemquerfazerhistoria.dao.Nivel2DAO;
import br.com.quemquerfazerhistoria.dao.Nivel3DAO;
import br.com.quemquerfazerhistoria.model.Nivel1;
import br.com.quemquerfazerhistoria.model.Nivel2;
import br.com.quemquerfazerhistoria.model.Nivel3;
import br.com.quemquerfazerhistoria.model.Personagem;
import br.com.quemquerfazerhistoria.utils.Utils;
import br.com.quemquerfazerhistoria.utils.UtilsController;

@Controller
public class HomeController {
	
	private String titulo;
	private List<Personagem> lstPersonagem;


	@RequestMapping("/")
	public String homebarra() { 
		return "redirect:aHome";
	}
	
	@RequestMapping("/aHome")
	public String home(Model model, HttpServletRequest req) { 
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		return "aHome";
	}

	@RequestMapping("/pnivel1")
	public String nivel1(Model model, HttpServletRequest req, int p) { 
		Nivel1DAO nivelDao	= new Nivel1DAO(Utils.conexao(req));
		
		List<Nivel1> lstNivel1 = nivelDao.lista(p);
		this.titulo = 			lstNivel1.get(0).getTitulo();
		
		model.addAttribute("lstNivel1", 		lstNivel1);
		model.addAttribute("titulo", 			this.titulo);
		model.addAttribute("caminhoimagem", 	lstNivel1.get(0).getCaminhoimagem());
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		return "pNivel1";
	}
	
	@RequestMapping("/pnivel2")
	public String nivel2(Model model, HttpServletRequest req, int p, int n1/*, int r*/) { 
		
		Nivel2DAO nivelDao	= new Nivel2DAO(Utils.conexao(req));
		List<Nivel2> lstNivel2 = nivelDao.lista(n1);
		
		model.addAttribute("lstNivel2", 	lstNivel2);
		model.addAttribute("titulo", 		this.titulo);
		model.addAttribute("textoanterior", lstNivel2.get(0).getTextonivel1());
		model.addAttribute("caminhoimagem", lstNivel2.get(0).getCaminhoimagem());
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		return "pNivel2";
	}
	
	@RequestMapping("/pnivel3")
	public String nivel3(Model model, HttpServletRequest req, int p, int n1, int n2) { 
		Nivel3DAO nivelDao	= new Nivel3DAO(Utils.conexao(req));
		
		List<Nivel3> lstNivel3 = nivelDao.lista(n2);
		
		model.addAttribute("lstNivel3", 	lstNivel3);
		model.addAttribute("titulo", 		this.titulo);
		model.addAttribute("textoanterior", lstNivel3.get(0).getTextonivel2());
		model.addAttribute("caminhoimagem", lstNivel3.get(0).getCaminhoimagem());
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		return "pNivel3";
	}
	
	@RequestMapping("/phistoriagerada")
	public String phistoriagerada(Model model, HttpServletRequest req, int p, int n1, int n2, int n3) { 
		HistoriaGeradaDAO hgDao = new HistoriaGeradaDAO(Utils.conexao(req));
		model.addAttribute("objHistoria", hgDao.getHistoria(p, n1, n2, n3));
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		return "pHistoriaGerada";
	}


	
	


}

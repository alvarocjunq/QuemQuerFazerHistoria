package br.com.quemquerfazerhistoria.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.quemquerfazerhistoria.model.HistoriaGerada;
import br.com.quemquerfazerhistoria.model.Personagem;
import br.com.quemquerfazerhistoria.service.GerarHistoriaAleatoriaService;
import br.com.quemquerfazerhistoria.utils.Utils;
import br.com.quemquerfazerhistoria.utils.UtilsController;

@Controller
public class RandomController {
	private List<Personagem> lstPersonagem;
	private HistoriaGerada hg;
	private int ultimoNivel1IDRandom; 
	
	@RequestMapping("/historiarandom")
	public String historiarandom(Model model, HttpServletRequest req) {
		
		//Se estiver nulo, instancia
		this.hg = (this.hg == null ? new HistoriaGerada() : this.hg);

		//Continue sorteando uma historia se ela for igual a ultima historia gerada
		while (this.hg.getNivel1id() == this.ultimoNivel1IDRandom){
			this.hg = new GerarHistoriaAleatoriaService(Utils.conexao(req)).getHistoria();
		}
		this.ultimoNivel1IDRandom = this.hg.getNivel1id();
		
		//Monta a querystring para um possovel copy paste do usuario na barra de endereco
		String qs = UtilsController.montaQueryStringHistoriaGerada(req, this.hg);
		
		model.addAttribute("objHistoria", this.hg);
		model.addAttribute("querystring", "window.history.pushState('qs','querystring',"+qs);
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		return "pHistoriaGerada";
	}

}

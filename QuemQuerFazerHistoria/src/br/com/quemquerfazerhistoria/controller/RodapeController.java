package br.com.quemquerfazerhistoria.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.quemquerfazerhistoria.dao.NewsletterDAO;
import br.com.quemquerfazerhistoria.enums.GlobalEnum;
import br.com.quemquerfazerhistoria.model.EnviarUmDesenho;
import br.com.quemquerfazerhistoria.model.Newsletter;
import br.com.quemquerfazerhistoria.model.Personagem;
import br.com.quemquerfazerhistoria.model.SugerirPersonagem;
import br.com.quemquerfazerhistoria.service.EnviarUmDesenhoService;
import br.com.quemquerfazerhistoria.service.SugerirPersonagemService;
import br.com.quemquerfazerhistoria.utils.Email;
import br.com.quemquerfazerhistoria.utils.Upload;
import br.com.quemquerfazerhistoria.utils.Utils;
import br.com.quemquerfazerhistoria.utils.UtilsController;

@Controller
public class RodapeController {

	private Utils utils;
	private List<Personagem> lstPersonagem;
	
	@RequestMapping("/newsletter")
	public String newsletter(Model model, HttpServletRequest req, Newsletter nw)
	{
		this.utils = new Utils();
		boolean inseriu = new NewsletterDAO(Utils.conexao(req)).inserir(nw);
		
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		if(inseriu)
		{
			model.addAttribute("mensagem", "E-mail cadastrado com sucesso!");
			String mensagem = "O e-mail: " + nw.getEmail() + " acaba de se cadastrar para receber novas histórias";
			Email.enviaEmail(nw.getEmail(), "Cadastro de newsletter", mensagem, GlobalEnum.ANEXO_VAZIO.getValor());
		}
		else
			model.addAttribute("mensagem", "Seu e-mail não pode ser cadastrado, envie um e-mail para " + utils.getProp("emailadministrador"));
		
		return "pNewsletter";
	}
	
	@RequestMapping("/comofunciona")
	public String comofunciona(Model model, HttpServletRequest req, Newsletter nw)
	{
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		return "pComoFunciona";
	}
	
	@RequestMapping("/psugerirpersonagem")
	public String psugerirpersonagem(Model model, HttpServletRequest req, SugerirPersonagem sp)
	{
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		return "pSugerirPersonagem";
	}
	
	@RequestMapping("/sugerirpersonagem")
	public String sugerirpersonagem(Model model, HttpServletRequest req, SugerirPersonagem sp)
	{
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		if(Utils.isBrancoOuNulo(sp.getEmailremetente()) || Utils.isBrancoOuNulo(sp.getPersonagem()))
			return "redirect:psugerirpersonagem";
		
		SugerirPersonagemService sps = new SugerirPersonagemService();
		sps.sugerir(sp);
		
		return "redirect:psugerirpersonagem";
	}
	
	@RequestMapping("/penviarumdesenho")
	public String penviarumdesenho(Model model, HttpServletRequest req, EnviarUmDesenho eud)
	{
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		return "pEnviarUmDesenho";
	}
	
	@RequestMapping(value = "/enviarumdesenho", method = RequestMethod.POST)
	public String enviarumdesenho(Model model, HttpServletRequest req, EnviarUmDesenho eud)
	{
		UtilsController.carregarListaPersonagem(model, req, this.lstPersonagem);
		
		if(Utils.isBrancoOuNulo(eud.getEmailremetente()) || 
				Utils.isBrancoOuNulo(eud.getPersonagem()) || 
				eud.getAnexo().equals(null))
			return "redirect:penviarumdesenho";
		
		Upload up = new Upload();
		
		//Efetua o upload
		File arquivo = up.armazenar(req, eud.getAnexo());
		
		//Envia o email com o anexo
		EnviarUmDesenhoService euds = new EnviarUmDesenhoService();
		euds.enviar(eud, arquivo);

		//Remove o arquivo temporário
		up.removerArqTmp(arquivo); 
		
		return "redirect:penviarumdesenho";
	}

}

package br.com.quemquerfazerhistoria.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.quemquerfazerhistoria.utils.Log;

@Controller
public class TratarErroController {
	
	@RequestMapping("404")
	public String execute404(Model model, HttpServletRequest req) {
		Log.setErro("Página não encontrada - 404 [Erro disparado pelo HTTP]");
		return "redirect:aHome"; 
	}
	
	@RequestMapping("500")
	public String execute500() {
		Log.setErro("Houve um erro de codificação - 500 [Erro disparado pelo HTTP]");
		return "redirect:aHome"; 
	}
}

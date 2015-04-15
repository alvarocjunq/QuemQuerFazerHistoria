package br.com.quemquerfazerhistoria.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import br.com.quemquerfazerhistoria.dao.PersonagemDAO;
import br.com.quemquerfazerhistoria.model.HistoriaGerada;
import br.com.quemquerfazerhistoria.model.Personagem;

public class UtilsController {
	

	/**
	 * Cria a queryString para a p�gina de hist�ria gerada
	 * @param req
	 * @return
	 */
	public static String montaQueryStringHistoriaGerada(HttpServletRequest req, HistoriaGerada hg) {
		String qs = "p="+hg.getPersonagemid();
		qs+= "&n1=" + hg.getNivel1id();
		qs+= "&n2=" + hg.getNivel2id();
		qs+= "&n3=" + hg.getNivel3id();
		qs = "'/" + Utils.getNomeContexto(req.getRequestURL().toString()) + "/phistoriagerada?"+qs+"');";
		return qs;
	}
	
	/**
	 * @param model
	 * @param req
	 */
	public static List<Personagem> carregarListaPersonagem(Model model, HttpServletRequest req, List<Personagem> lstPersonagem) {
		
		if(lstPersonagem == null)
		{
			PersonagemDAO personagemDao = new PersonagemDAO(Utils.conexao(req));
			lstPersonagem = personagemDao.lista();
		}
		return lstPersonagem;
	}
}

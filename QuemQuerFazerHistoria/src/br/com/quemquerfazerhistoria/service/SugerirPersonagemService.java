package br.com.quemquerfazerhistoria.service;

import br.com.quemquerfazerhistoria.model.SugerirPersonagem;
import br.com.quemquerfazerhistoria.utils.Email;

public class SugerirPersonagemService {

	/**
	 * Envia um email com a sugestão do personagem
	 * @param sp
	 */
	public void sugerir(SugerirPersonagem sp)
	{
		String email = "Personagem: " + sp.getPersonagem();
		email += "\n\n";
		email += "Descrição: " + sp.getDescricao();
		
		Email.enviaEmail(sp.getEmailremetente(), "Sugestão de personagem", email, null);
	}
}

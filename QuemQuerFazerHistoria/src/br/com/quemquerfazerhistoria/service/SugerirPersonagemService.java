package br.com.quemquerfazerhistoria.service;

import br.com.quemquerfazerhistoria.model.SugerirPersonagem;
import br.com.quemquerfazerhistoria.utils.Email;

public class SugerirPersonagemService {

	/**
	 * Envia um email com a sugest�o do personagem
	 * @param sp
	 */
	public void sugerir(SugerirPersonagem sp)
	{
		String email = "Personagem: " + sp.getPersonagem();
		email += "\n\n";
		email += "Descri��o: " + sp.getDescricao();
		
		Email.enviaEmail(sp.getEmailremetente(), "Sugest�o de personagem", email, null);
	}
}

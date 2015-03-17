package br.com.quemquerfazerhistoria.test;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import br.com.quemquerfazerhistoria.model.SugerirPersonagem;
import br.com.quemquerfazerhistoria.utils.Email;

public class SugerirPersonagemTest {

	@Test
	public void sugerirUmPersonagemEnviaPorEmail() {
		SugerirPersonagem sp = new SugerirPersonagem();
		sp.setEmailremetente("alvarocjunq@teste.com");
		sp.setPersonagem("Personagem teste");
		sp.setDescricao("Descrição do personagem do usuário");
		
		StringBuilder email = new StringBuilder();
		email.append("Personagem: " + sp.getPersonagem());
		email.append("\n\n");
		email.append("Descrição: " + sp.getDescricao());
		
		File anexo = new File("/home/alvaro/Firefox_wallpaper.png");

		Assert.assertTrue(Email.enviaEmail( sp.getEmailremetente(),
											"Sugestão de personagem", 
											email.toString(), 
											anexo));
	}

}

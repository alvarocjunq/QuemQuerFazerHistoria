package br.com.quemquerfazerhistoria.test;

import java.io.File;

import br.com.quemquerfazerhistoria.model.SugerirPersonagem;
import br.com.quemquerfazerhistoria.utils.Email;

public class SugerirPersonagemTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SugerirPersonagem sp = new SugerirPersonagem();
		sp.setEmailremetente("alvarocjunq@teste.com");
		sp.setPersonagem("Personagem teste");
		sp.setDescricao("Minha descri��o maluca de chessus");
		
		String email = "Personagem: " + sp.getPersonagem();
		email += "\n\n";
		email += "Descri��o: " + sp.getDescricao();
		
		File anexo = new File("C:\\Users\\Alvaro\\Pictures\\Papeis de parede\\618486main_earth_full2.jpg");

		Email.enviaEmail(sp.getEmailremetente(), "Sugest�o de personagem", email, anexo);
	}

}

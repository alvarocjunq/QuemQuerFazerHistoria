package br.com.quemquerfazerhistoria.service;

import java.io.File;

import br.com.quemquerfazerhistoria.model.EnviarUmDesenho;
import br.com.quemquerfazerhistoria.utils.Email;

public class EnviarUmDesenhoService {

	public void enviar(EnviarUmDesenho eud, File anexo)
	{
		String email = "Personagem: " + eud.getPersonagem();
		email += "\n\n";
		email += "Descrição: " + eud.getDescricao();
		
		Email.enviaEmail(eud.getEmailremetente(), "Envio de desenho", email, anexo);
	}
}

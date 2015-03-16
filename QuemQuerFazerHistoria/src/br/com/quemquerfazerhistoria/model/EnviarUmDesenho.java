package br.com.quemquerfazerhistoria.model;

import org.springframework.web.multipart.MultipartFile;

public class EnviarUmDesenho {
	private String emailremetente;
	private String personagem;
	private String descricao;
	private MultipartFile anexo;

	public String getEmailremetente() {
		return emailremetente;
	}
	public void setEmailremetente(String emailremetente) {
		this.emailremetente = emailremetente;
	}
	public String getPersonagem() {
		return personagem;
	}
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public MultipartFile getAnexo() {
		return anexo;
	}
	public void setAnexo(MultipartFile anexo) {
		this.anexo = anexo;
	}
}
package br.com.quemquerfazerhistoria.model;

public class Nivel1 {
	private int nivel1id;
	private int personagemid;
	private String label;
	private String texto;
	private String titulo;
	private String caminhoimagem;
	
	
	public String getCaminhoimagem() {
		return caminhoimagem;
	}
	public void setCaminhoimagem(String caminhoimagem) {
		this.caminhoimagem = caminhoimagem;
	}
	public int getNivel1id() {
		return nivel1id;
	}
	public void setNivel1id(int nivel1id) {
		this.nivel1id = nivel1id;
	}
	public int getPersonagemid() {
		return personagemid;
	}
	public void setPersonagemid(int personagemid) {
		this.personagemid = personagemid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}

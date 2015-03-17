package br.com.quemquerfazerhistoria.model;

public class Nivel2 {
	private int nivel2id;
	private int nivel1id;
	private String label;
	private String texto;
	private String textonivel1;
	private String caminhoimagem;
	
	
	public String getCaminhoimagem() {
		return caminhoimagem;
	}
	public void setCaminhoimagem(String caminhoimagem) {
		this.caminhoimagem = caminhoimagem;
	}
	public int getNivel2id() {
		return nivel2id;
	}
	public void setNivel2id(int nivel2id) {
		this.nivel2id = nivel2id;
	}
	public int getNivel1id() {
		return nivel1id;
	}
	public void setNivel1id(int nivel1id) {
		this.nivel1id = nivel1id;
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
	public String getTextonivel1() {
		return textonivel1;
	}
	public void setTextonivel1(String textonivel1) {
		this.textonivel1 = textonivel1;
	}
	
}

package br.com.quemquerfazerhistoria.model;

public class Nivel3 {
	private int nivel3id;
	private int nivel2id;
	private String label;
	private String texto;
	private String textonivel2;
	private String caminhoimagem;
	
	
	public String getCaminhoimagem() {
		return caminhoimagem;
	}
	public void setCaminhoimagem(String caminhoimagem) {
		this.caminhoimagem = caminhoimagem;
	}
	public int getNivel3id() {
		return nivel3id;
	}
	public void setNivel3id(int nivel3id) {
		this.nivel3id = nivel3id;
	}
	public int getNivel2id() {
		return nivel2id;
	}
	public void setNivel2id(int nivel2id) {
		this.nivel2id = nivel2id;
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
	public String getTextonivel2() {
		return textonivel2;
	}
	public void setTextonivel2(String textonivel2) {
		this.textonivel2 = textonivel2;
	}
	
}

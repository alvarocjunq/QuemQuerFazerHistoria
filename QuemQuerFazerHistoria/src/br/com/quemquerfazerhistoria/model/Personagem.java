package br.com.quemquerfazerhistoria.model;

public class Personagem {
	private int personagemid;
	private String descricao;
	private String tratamento;
	private String caminhoimagem;
	
	
	public String getCaminhoimagem() {
		return caminhoimagem;
	}
	public void setCaminhoimagem(String caminhoimagem) {
		this.caminhoimagem = caminhoimagem;
	}
	public int getPersonagemid() {
		return personagemid;
	}
	public void setPersonagemid(int personagemid) {
		this.personagemid = personagemid;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	
	
}

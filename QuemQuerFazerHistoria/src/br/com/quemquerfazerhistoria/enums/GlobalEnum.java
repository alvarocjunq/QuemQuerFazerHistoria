package br.com.quemquerfazerhistoria.enums;

import java.io.File;

public enum GlobalEnum {

	ANEXO_VAZIO(null);

	private File anexoVazio;

	GlobalEnum(File anexo) {
		anexoVazio = anexo;
	}
	
	public File getValor(){
		return anexoVazio;
	}
}

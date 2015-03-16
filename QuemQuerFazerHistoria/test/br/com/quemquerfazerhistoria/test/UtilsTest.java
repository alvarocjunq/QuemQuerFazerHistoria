package br.com.quemquerfazerhistoria.test;


public class UtilsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("numero: " + getNumero(18, 9999));
	}
	
	public static String getNumero(int qtdCarac, int range)
	{
		String retorno = "";
		for(int i=0; i<qtdCarac;i++)
			retorno += "0" ;
		String concat = retorno;
		int numero = (int)(Math.random()*(range+1));
		retorno = retorno + numero;
		retorno = retorno.substring(retorno.length()-qtdCarac, retorno.length());
		return (retorno == concat ? concat +"1" : retorno);
	}

}

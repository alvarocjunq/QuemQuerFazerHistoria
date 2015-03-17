package br.com.quemquerfazerhistoria.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class Utils {
	
	public String getProp(String chave) 
	{
		try{
			Properties objProp = new Properties();
			objProp.load(getClass().getResourceAsStream("/br/com/quemquerfazerhistoria/quemquer.properties"));
			return objProp.getProperty(chave);
			
		}catch (Exception e) {
			Log.setErro("Erro ao chamar arquivo properties (quemquer.properties");
			Log.setDebug(""+e.getStackTrace());
			return null;
		}
        
	}
	
	public static Connection conexao(HttpServletRequest req)
	{
		return (Connection)req.getAttribute("conexao");
	}

	public static String nvl(String a, String b)
	{
		return (a == null ? b : a);
	}
	
	public static String getTipoCritica(String texto){
		return texto.substring(texto.length()-1, texto.length());
	}
	
	public static String getTextoCritica(String texto){
		return texto.substring(0, texto.length()-2);
	}
	
	public static String alteraCaracterEncoding(String str)
	{
		str = str.replace("%20", " ");
		str = str.replace("%21", "!");
		str = str.replace("%22", "\"");
		str = str.replace("%23", "#");
		str = str.replace("%24", "$");
		str = str.replace("%25", "%");
		str = str.replace("%26", "&");
		str = str.replace("%27", "'");
		str = str.replace("%28", "(");
		str = str.replace("%29", ")");
		str = str.replace("%2a", "*");
		str = str.replace("%2b", "+");
		str = str.replace("%2c", ",");
		str = str.replace("%2d", "-");
		str = str.replace("%2e", ".");
		str = str.replace("%2f", "/");

		return str;
	}
	
	/**
	 * Copia um arquivo de um ponto a outro
	 * 
	 * @param arquivo Caminho com o nome do arquivo a ser copiado
	 * @param destino Caminho com o nome do arquivo de destino
	 * @throws IOException
	 */
	public static void copiarArquivo(File arquivo, File destino) throws IOException {     
	     if (destino.exists())     
	         destino.delete();     
	    
	     FileChannel sourceChannel = null;     
	     FileChannel destinationChannel = null;     
	    
	     try {     
	         sourceChannel = new FileInputStream(arquivo).getChannel();
	         destinationChannel = new FileOutputStream(destino).getChannel();
	         sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);     
	     } finally {     
	         if (sourceChannel != null && sourceChannel.isOpen())     
	             sourceChannel.close();     
	         if (destinationChannel != null && destinationChannel.isOpen())     
	             destinationChannel.close();     
	    }     
	}
	
	public static void verificaPastaExistente(String caminho){
		File file = new File(caminho);
	    
		if(!file.exists())
			file.mkdirs();
	}
	
	/**
	 * Verifica se a imagem passada é uma imagem aceita pelo framework
	 * As imagems aceitas, ficam configuradas no arquivo properties separados pos virgula
	 */
	public static boolean isImagemValida(String nomeImg)
	{
		String nome = nomeImg.substring(nomeImg.length()-3).toUpperCase();
		String [] tipos = new Utils().getProp("tipoImgValida").split(",");
		
		for(String iTipo: tipos)
		{
			if(iTipo.toUpperCase().equals(nome))
				return true;
		}
				return false;
	}
	
	/**
	 * Retorna o texto passado por parametro, com a primeira letra maiuscula
	 * @param texto
	 * @return
	 */
	public static String primeiraMaiuscula(String texto)
    {
        return texto.substring(0,1).toUpperCase() + texto.substring(1,texto.length());
    }
	
	/**
	 * Gera espa�os de acordo com a quantidade informada
	 * @param qtd
	 * @return
	 */
	public static String gerarEspaco(int qtd)
    {
        String espaco = "";
        for(int i = 0; i < qtd; i++)
        {
            espaco += " ";
        }
        return espaco;
    }

	/**
	 * Retorna a data atual em String de acordo com o formato enviado
	 * @param formato Enviar formatos conhecidos pelo SimpleDateFormat
	 * @return Data formatada do tipo String
	 */
	public static String getDataAtualString(String formato) {
		return new SimpleDateFormat(formato).format(new Date());
	}

	/**
	 * Retorna um n�mero aleat�rio, de 0-N
	 * @param range = at� que n�mero pode ser retornado
	 */
	public static int getNumRandom(int range)
	{
		return (int)(Math.random()*range);
	}
	
	public static String getNomeContexto(String url)
	{
		String b = url.substring(0, url.lastIndexOf('/'));
		return b.substring(b.lastIndexOf('/')+1, b.length());
	}

	public static boolean isBrancoOuNulo(String str)
	{
		if(str == null)
			return true;
		
		if(str.equals(null))
			return true;
		
		if(str == "")
			return true;
		
		return false;
	}

	/**
	 * Retorna a extens�o de um arquivo
	 * @param arquivo
	 * @return
	 */
	public static String getExtensaoArq(String arquivo)
	{
		return arquivo.substring(arquivo.lastIndexOf('.'), arquivo.length());
	}
}

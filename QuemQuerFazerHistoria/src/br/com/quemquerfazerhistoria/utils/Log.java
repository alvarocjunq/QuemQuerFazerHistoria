package br.com.quemquerfazerhistoria.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

	public static void setErro(String info){
		gerarLog(info, "ERROR");
	}
	
	public static void setLog(String info){
		gerarLog(info, "LOGAR");
	}

	public static void setDebug(String info){
		gerarLog(info, "DEBUG");
	}
	
	/**
	 * Gera arquivo de Log
	 * @param info
	 * @throws IOException
	 */
	private static void gerarLog(String info, String tipo) {
		try {
			String caminhoLog 		= new Utils().getProp("caminhoPadraoLog");
			String dataFormatada 	= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			String [] arqlogs 		= new File(caminhoLog).list();
			int count				= 0;
			boolean tipoCorreto 	= false;
			boolean dataCorreta 	= false;
			File arquivoLog;
			
			Utils.verificaPastaExistente(caminhoLog);
			
			//-------------------
			// Verifica quantos arquivos do tipo enviado e da data de hoje existem na pasta
			//-------------------
			if(!arqlogs.equals(null))
			{
				for(String iArq: arqlogs)
				{
					//-------------------
					// Verifica se é um arquivo válido
					//-------------------
					if(iArq.endsWith(".log") && iArq.length() > 15)
					{
						tipoCorreto = getTipoArquivo(iArq).equals(tipo);
						dataCorreta = getDataArquivo(iArq).equals(Utils.getDataAtualString("ddMMyyyy"));
					
						if(tipoCorreto && dataCorreta)
							count++;
					}
				}
			}
			
			//-------------------
			// Se tem algum arquivo do tipo enviado na pasta, faz as verificações
			// Se não tem, gera o primeiro arquivo do tamanho zero
			//-------------------
			if(count > 0)
			{
				//-------------------
				// Monta o arquivo com o maior numero na pasta (Quantidade total de arquivos - 1)
				//-------------------
				arquivoLog = new File(getNomeArquivo(caminhoLog, count-1, tipo));
				
				//-------------------
				// Se o arquivo estiver maior que o máximo, crio arquivo com o próximo número
				//-------------------
				if(arquivoLog.exists() && arquivoLog.length() > 45000)
				{
					arquivoLog = new File(getNomeArquivo(caminhoLog , count, tipo));
				}
			}
			else
			{
				 arquivoLog	= new File(getNomeArquivo(caminhoLog, 0, tipo));
			}
			
			//-------------------
			// Adiciona a informação
			//-------------------
			BufferedWriter arqLog = new BufferedWriter(new FileWriter(arquivoLog, true));
			
			arqLog.write(dataFormatada + " #" + info);
			arqLog.newLine();
			arqLog.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getTipoArquivo(String nomeArquivo)
	{
		return nomeArquivo.substring(nomeArquivo.lastIndexOf("_")+1, nomeArquivo.length()-4);
	}
	
	private static String getDataArquivo(String nomeArquivo)
	{
		return nomeArquivo.substring(0, 8);
	}
	
	private static String getNomeArquivo(String caminho, int numArquivo, String tipo)
	{
		return caminho + Utils.getDataAtualString("ddMMyyyy") + "_" + numArquivo + "_" + tipo +".log";
	}
	
}

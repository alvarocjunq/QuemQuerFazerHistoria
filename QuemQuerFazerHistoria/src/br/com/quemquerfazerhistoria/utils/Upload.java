package br.com.quemquerfazerhistoria.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Upload {

	/**
	 *  Efetua o upload da máquina do usuário para o servidor
	 * @param request Usado para pegar o contexto e o caminho da aplicação
	 * @param file Arquivo a ser efeutado o upload
	 * @return
	 */
	public File armazenar(HttpServletRequest request, MultipartFile file) {
		
		try {
			byte[] bytes = file.getBytes();
			String dataHoraAtual = Utils.getDataAtualString("ddMMyyyy_HHmmss_SSSS");

			String dir = request.getServletContext().getRealPath("resources/imagens/upload/");
			String nomeArquivo = dir + File.separator + "arquivoTmp_" + dataHoraAtual + Utils.getExtensaoArq(file.getOriginalFilename());
			File arq = new File(nomeArquivo);
			
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(arq));
            stream.write(bytes);
            stream.close();
            
			return arq;

		} catch (Exception e) {
			Log.setErro("---------------------");
			Log.setErro("Erro ao fazer upload de arquivo");
			Log.setErro("0 - "+ e.getMessage());
			Log.setErro("---------------------");
			e.printStackTrace();
		}
		return null;
	}
	
	public void removerArqTmp(File arquivo)
	{
		arquivo.delete();
	}
}

package br.com.quemquerfazerhistoria.utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {

	/**
	 * @param remetente
	 *            Separar os destinatários por vírgula
	 */
	public static void enviaEmail(String remetente, String assunto, String mensagem, File anexo) {
		Properties props = new Properties();
		final Utils utils = new Utils();
		/** Parâmetros de conexão com servidor Gmail */
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user", "username");
	    props.put("mail.smtp.password", "password");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", true);

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(utils
								.getProp("emailadministrador"), utils
								.getProp("senhaemailadministrador"));
					}
				});

		session.setDebug(false);

		try {

			Message message = new MimeMessage(session);
			Multipart mp = new MimeMultipart();
			MimeBodyPart parteTexto = new MimeBodyPart();
			
			//-----------------
		    // Conteúdo da mensagem
			//-----------------
			parteTexto.setText(mensagem);
			mp.addBodyPart(parteTexto);
			
			//-----------------
		    // Se houver anexo, adiciona 
			//-----------------
			if(anexo != null)
			{
			    MimeBodyPart parteComAnexo = new MimeBodyPart();
			    
		        //-----------------
		        // Cria o anexo
		        //-----------------
		        FileDataSource fds = new FileDataSource(anexo);
		        parteComAnexo.setDataHandler(new DataHandler(fds));
		        parteComAnexo.setFileName(fds.getName());
		        
		        //-----------------
		        // anexa o arquivo na mensagem
		        //-----------------
		        mp.addBodyPart(parteComAnexo);
			}
		    
			//-----------------
		    // Adiciona a Multipart na mensagem
			//-----------------
		    message.setContent(mp);

			//-----------------
			// Remetente
			//-----------------
			message.setFrom(new InternetAddress(remetente)); 

			//-----------------
			// Destinatário(s)
			//-----------------
			Address[] toUser = InternetAddress.parse(utils.getProp("emailadministrador"));

			message.setRecipients(Message.RecipientType.TO, toUser);
			
			//-----------------
			// Assunto
			//-----------------
			message.setSubject("[ENVIADO ATRAVES DO SITE] - " + assunto);
			
			//-----------------
			// Método para enviar a mensagem criada
			//-----------------
			Transport.send(message);

		} catch (MessagingException e) {
        	Log.setErro("-----------------------");
        	Log.setErro("Erro ao enviar email de: " + remetente);
        	Log.setErro("Assunto do e-mail: " + assunto);
        	Log.setErro("-----------------------");
        	Log.setErro("0 - " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Método para enviar email usando HTML, não está sendo usado
	 */
	public void enviaEmailHtml(){
	    Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", true); // added this line
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user", "username");
	    props.put("mail.smtp.password", "password");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", true);



	    Session session = Session.getInstance(props,null);
	    MimeMessage message = new MimeMessage(session);

//	    System.out.println("Port: "+session.getProperty("mail.smtp.port"));

	    // Create the email addresses involved
	    try {
	        InternetAddress from = new InternetAddress("username");
	        message.setSubject("Yes we can");
	        message.setFrom(from);
	        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("receivermail"));

	        // Create a multi-part to combine the parts
	        Multipart multipart = new MimeMultipart("alternative");

	        // Create your text message part
	        BodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText("some text to send");

	        // Add the text part to the multipart
	        multipart.addBodyPart(messageBodyPart);

	        // Create the html part
	        messageBodyPart = new MimeBodyPart();
	        String htmlMessage = "Our html text";
	        messageBodyPart.setContent(htmlMessage, "text/html");


	        // Add html part to multi part
	        multipart.addBodyPart(messageBodyPart);

	        // Associate multi-part with message
	        message.setContent(multipart);

	        // Send message
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", "username", "password");
	        System.out.println("Transport: "+transport.toString());
	        transport.sendMessage(message, message.getAllRecipients());


	    } catch (AddressException e) {
	        Log.setErro("Erro de AddressException ao enviar EMAIL");
	        e.printStackTrace();
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}
package br.com.quemquerfazerhistoria.test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.EditorKit;

public class Nivel3DAOTest {

	/**
	 */
	public static void main(String[] args) {
		//Connection con;
		//List<Nivel3> lista = new ArrayList<Nivel3>();
		//String a = "<div>&quot;Se seu navio você deseja, me encontre na praça da igreja </div> <div>A 5 e meia você me procure, que seu problema talvez eu cure</div> <div>Irei perguntar sua profissão, responda PIRATA de antemão </div> <div>Se assim não responder, um navio pirata você não vai ter&quot; &nbsp;</div> <div>&nbsp;</div> <div>";
		try {
//			con = new ConnectionFactory().getConnection(new Utils().getProp("databasepadrao"));
//			Nivel3DAO dao = new Nivel3DAO(con);
//			
//			
//			lista = dao.lista("1");
			
//			String rtfText = ...;
			String htmlText = rtfToHtml(new StringReader("<div>&quotalvaro/3"));
			System.out.println(htmlText);
//		} catch (SQLException e) {
//			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String rtfToHtml(Reader rtf) throws IOException {
		JEditorPane p = new JEditorPane();
		p.setContentType("text/rtf");
		EditorKit kitRtf = p.getEditorKitForContentType("text/rtf");
		try {
			kitRtf.read(rtf, p.getDocument(), 0);
			kitRtf = null;
			EditorKit kitHtml = p.getEditorKitForContentType("text/html");
			Writer writer = new StringWriter();
			kitHtml.write(writer, p.getDocument(), 0, p.getDocument().getLength());
			return writer.toString();
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		return null;
	}
}

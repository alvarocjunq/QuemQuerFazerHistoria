package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.quemquerfazerhistoria.model.HistoriaGerada;
import br.com.quemquerfazerhistoria.utils.Log;

public class HistoriaGeradaDAO {
	private final Connection connection;
	
	public HistoriaGeradaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public HistoriaGerada getHistoria(int personagemid, int nivel1id, int nivel2id, int nivel3id)
	{
		try {
			HistoriaGerada hg = new HistoriaGerada();
			String sql = "SELECT tblPersonagem.Descricao AS Personagem,                             "
					+"		 CONCAT(tblPersonagem.Tratamento,' ',tblPersonagem.Descricao) as Titulo,	"
					+"	   	 tblNivel1.CaminhoImagem AS CaminhoImagem1,                             "
					+"	     tblNivel2.CaminhoImagem AS CaminhoImagem2,                             "
					+"	     tblNivel3.CaminhoImagem AS CaminhoImagem3,                             "
					+"	   	 tblNivel1.Texto AS Texto1,                                             "
					+"	     tblNivel2.Texto AS Texto2,                                             "
					+"	     tblNivel3.Texto AS Texto3,                                             "
					+"	     tblNivel1.Label AS Label1,                                             "
					+"	     tblNivel2.Label AS Label2,                                             "
					+"       tblNivel3.Label AS Label3                                              "
					+"  FROM tblNivel1 INNER JOIN                                                   "
					+"       tblNivel2 ON tblNivel1.Nivel1ID = tblNivel2.Nivel1ID INNER JOIN        "
					+"       tblNivel3 ON tblNivel2.Nivel2ID = tblNivel3.Nivel2ID INNER JOIN        "
					+"       tblPersonagem ON tblNivel1.PersonagemID = tblPersonagem.PersonagemID   "
					+" WHERE tblPersonagem.PersonagemID = ?                                         "
					+"   AND tblNivel1.Nivel1ID = ?                                                 "
					+"   AND tblNivel2.Nivel2ID = ?                                                 "
					+"   AND tblNivel3.Nivel3ID = ?                                                ";
			
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			
			stmt.setInt(1, personagemid);
			stmt.setInt(2, nivel1id);
			stmt.setInt(3, nivel2id);
			stmt.setInt(4, nivel3id);
			
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				hg.setPersonagem	(rs.getString("Personagem"));
				hg.setTitulo		(rs.getString("Titulo"));
				hg.setTexto1		(rs.getString("Texto1"));
				hg.setTexto2		(rs.getString("Texto2"));
				hg.setTexto3		(rs.getString("Texto3"));
				hg.setLabel1		(rs.getString("Label1"));
				hg.setLabel2		(rs.getString("Label2"));
				hg.setLabel3		(rs.getString("Label3"));
				hg.setCaminhoimagemnivel1(rs.getString("CaminhoImagem1"));
				hg.setCaminhoimagemnivel2(rs.getString("CaminhoImagem2"));
				hg.setCaminhoimagemnivel3(rs.getString("CaminhoImagem3"));
			}

			rs.close();
			stmt.close();

			return hg;
			
		} catch (SQLException e) {
        	Log.setErro("-----------------------");
        	Log.setErro("Listar HistoriaGerada");
        	Log.setErro("-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
        	
        	return null;
		}
	}
}

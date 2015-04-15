package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quemquerfazerhistoria.model.Nivel1;
import br.com.quemquerfazerhistoria.utils.Log;

public class Nivel1DAO {
	private final Connection connection;
	
	public Nivel1DAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Nivel1> lista(int personagem)
	{
		try {
			List<Nivel1> lstPersonagem = new ArrayList<Nivel1>();
			String sql = "SELECT tblNivel1.Nivel1ID,"
					+"		 tblPersonagem.PersonagemID,"
					+"		 tblNivel1.Label,"
					+"		 tblNivel1.Texto,"
					+"		 tblPersonagem.Tratamento,"
					+"		 tblPersonagem.Descricao, "
					+"		 tblPersonagem.CaminhoImagem"
					+" FROM  tblNivel1 INNER JOIN"
					+"       tblPersonagem ON tblNivel1.PersonagemID = tblPersonagem.PersonagemID"
					+" WHERE tblPersonagem.PersonagemID = " + personagem;
			
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				Nivel1 nivel1 = new Nivel1();
				nivel1.setNivel1id		(rs.getInt("Nivel1ID"));
				nivel1.setPersonagemid	(rs.getInt("PersonagemID"));
				nivel1.setLabel			(rs.getString("Label"));
				nivel1.setTexto			(rs.getString("Texto"));
				nivel1.setTitulo		(rs.getString("Tratamento").concat(" ".concat(rs.getString("Descricao"))));
				nivel1.setCaminhoimagem(rs.getString("CaminhoImagem"));
				
				lstPersonagem.add(nivel1);
			}

			rs.close();
			stmt.close();

			return lstPersonagem;
			
		} catch (SQLException e) {
        	Log.setErro("-----------------------\nListar Nivel 1\n-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
        	
        	return null;
		}
	}
}

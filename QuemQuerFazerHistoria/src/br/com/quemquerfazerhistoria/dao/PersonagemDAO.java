package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quemquerfazerhistoria.model.Personagem;
import br.com.quemquerfazerhistoria.utils.Log;

public class PersonagemDAO {
	private final Connection connection;
	
	public PersonagemDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Personagem> lista()
	{
		try {
			List<Personagem> lstPersonagem = new ArrayList<Personagem>();
			String sql = "SELECT PersonagemID,"
					 +"	  	  Descricao," 
					 +"	  	  Tratamento,"
					 +"	  	  CaminhoImagem"
					 +"	 FROM tblPersonagem";
			
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				Personagem personagem = new Personagem();
				personagem.setPersonagemid(rs.getInt("PersonagemID"));
				personagem.setDescricao(rs.getString("Descricao"));
				personagem.setTratamento(rs.getString("Tratamento"));
				personagem.setCaminhoimagem(rs.getString("CaminhoImagem"));
				
				lstPersonagem.add(personagem);
			}

			rs.close();
			stmt.close();

			return lstPersonagem;
			
		} catch (SQLException e) {
        	Log.setErro("-----------------------\nListar Personagens\n-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
        	return null;
		}
	}
}

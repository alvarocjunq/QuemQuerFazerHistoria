package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quemquerfazerhistoria.model.Nivel2;
import br.com.quemquerfazerhistoria.utils.Log;

public class Nivel2DAO {
	private final Connection connection;
	
	public Nivel2DAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Nivel2> lista(int n1)
	{
		try {
			List<Nivel2> lstPersonagem = new ArrayList<Nivel2>();
			String sql = "SELECT tblNivel2.Nivel2ID, "
						+"		tblNivel2.Nivel1ID, "
						+"		tblNivel2.Label, "
						+"		tblNivel2.Texto, "
						+"		tblNivel1.Texto AS TextoNivel1, "
						+"		tblNivel1.CaminhoImagem "
						+"FROM  tblNivel2 INNER JOIN "
						+"      tblNivel1 ON tblNivel2.Nivel1ID = tblNivel1.Nivel1ID "
						+"WHERE	tblNivel1.Nivel1ID = " + n1;
			
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				Nivel2 nivel2 = new Nivel2();
				nivel2.setNivel2id		(rs.getInt("Nivel2ID"));
				nivel2.setNivel1id		(rs.getInt("Nivel1ID"));
				nivel2.setLabel			(rs.getString("Label"));
				nivel2.setTexto			(rs.getString("Texto"));
				nivel2.setTextonivel1	(rs.getString("TextoNivel1"));
				nivel2.setCaminhoimagem(rs.getString("CaminhoImagem"));
				
				lstPersonagem.add(nivel2);
			}

			rs.close();
			stmt.close();

			return lstPersonagem;
			
		} catch (SQLException e) {
        	Log.setErro("-----------------------\nListar Nivel 2\n-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
        	
        	return null;
		}
	}
}

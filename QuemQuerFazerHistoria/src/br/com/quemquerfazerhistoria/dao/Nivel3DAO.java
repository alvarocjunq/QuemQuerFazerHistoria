package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.quemquerfazerhistoria.model.Nivel3;
import br.com.quemquerfazerhistoria.utils.Log;

public class Nivel3DAO {
	private final Connection connection;
	
	public Nivel3DAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Nivel3> lista(int nivel2)
	{
		try {
			List<Nivel3> lstPersonagem = new ArrayList<Nivel3>();
			String sql= "SELECT tblNivel3.Nivel3ID, "
						+"		tblNivel3.Nivel2ID, "
						+"		tblNivel3.Label, "
						+"		tblNivel3.Texto, "
						+"		tblNivel2.Texto AS TextoNivel2, "
						+"		tblNivel2.CaminhoImagem "
						+"FROM  tblNivel3 INNER JOIN "
						+"      tblNivel2 ON tblNivel3.Nivel2ID = tblNivel2.Nivel2ID "
						+"WHERE	tblNivel2.Nivel2ID = " + nivel2;
			
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			ResultSet rs = stmt.executeQuery(); 

			while (rs.next()) {
				Nivel3 nivel3 = new Nivel3();
				nivel3.setNivel3id		(rs.getInt("Nivel3ID"));
				nivel3.setNivel2id		(rs.getInt("Nivel2ID"));
				nivel3.setLabel			(rs.getString("Label"));
				nivel3.setTexto			(rs.getString("Texto"));
				nivel3.setTextonivel2	(rs.getString("TextoNivel2"));
				nivel3.setCaminhoimagem (rs.getString("CaminhoImagem"));
				
				lstPersonagem.add(nivel3);
			}

			rs.close();
			stmt.close();

			return lstPersonagem;
			
		} catch (SQLException e) {
        	Log.setErro("-----------------------\nListar Nivel 3\n-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
        	
        	return null;
		}
	}
}

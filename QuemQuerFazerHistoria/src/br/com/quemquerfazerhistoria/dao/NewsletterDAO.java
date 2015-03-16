package br.com.quemquerfazerhistoria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.quemquerfazerhistoria.model.Newsletter;
import br.com.quemquerfazerhistoria.utils.Log;

public class NewsletterDAO {
	private final Connection connection;
	
	public NewsletterDAO(Connection connection) {
		this.connection = connection;
	}
	
	public boolean inserir(Newsletter nw)
	{
		try {
			String sql = "INSERT INTO tblNewsletter (Email) VALUES ( ? )";
			PreparedStatement stmt = this.connection.prepareStatement (sql);
			
			stmt.setString(1, nw.getEmail());
			stmt.executeUpdate();
			
			return true;
		
		} catch (SQLException e) {
        	Log.setErro("-----------------------");
        	Log.setErro("Listar HistoriaGerada");
        	Log.setErro("-----------------------");
        	Log.setErro(e.getErrorCode() + " - " + e.getMessage());
			return false;
		}
	}
}

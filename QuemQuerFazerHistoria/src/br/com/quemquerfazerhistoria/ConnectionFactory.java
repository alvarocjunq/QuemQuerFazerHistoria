package br.com.quemquerfazerhistoria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.quemquerfazerhistoria.utils.Log;
import br.com.quemquerfazerhistoria.utils.Utils;

public class ConnectionFactory {

	public Connection getConnection(String banco) throws SQLException {
		Connection connection 	= null;
		Utils utils				= new Utils();
		String user 			= utils.getProp("userBanco");
		String senha 			= utils.getProp("senhaBanco");
		try 
		{
			switch (banco.toUpperCase()) {
			case "ORACLE":
				Class.forName(utils.getProp("driverOracle"));
				connection =  DriverManager.getConnection(utils.getProp("conStringOracle"), user, senha);
				break;
			case "SQLSERVER":
				Class.forName(utils.getProp("driverSQLServer"));
				connection = DriverManager.getConnection(utils.getProp("conStringSQLSERVER"), user, senha);
				break;
			case "MYSQL":
				Class.forName(utils.getProp("driverMYSQL"));
				connection = DriverManager.getConnection(utils.getProp("conStringMYSQL"), user, senha);
				break;
			default:
				Log.setErro("Nao foi configurado o 'databasepadrao' no arquivo properties");
				break;
			}
		}
        catch(SQLException ex) {
        	Log.setErro("Erro de SQLException - Conexao com o banco");
        	Log.setErro(ex.getErrorCode() + " - " + ex.getMessage());
        }
		catch (ClassNotFoundException e) {
			Log.setErro("Erro de ClassNotFoundException - Conexao com o banco");
		}
		
		return connection;
	}

}

package br.com.quemquerfazerhistoria.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.util.Assert;

import br.com.quemquerfazerhistoria.ConnectionFactory;
import br.com.quemquerfazerhistoria.model.HistoriaGerada;
import br.com.quemquerfazerhistoria.service.GerarHistoriaAleatoriaService;
import br.com.quemquerfazerhistoria.utils.Utils;

public class GerarHistoriaAleatoriaDAOTest {
	public static void main(String[]args) throws SQLException
	{
		Connection con = new ConnectionFactory().getConnection(new Utils().getProp("databasepadrao"));
		GerarHistoriaAleatoriaService dao = new GerarHistoriaAleatoriaService(con);
		HistoriaGerada hg = new HistoriaGerada();
		hg = dao.getHistoria();
		
		Assert.isTrue(hg != null);
		
	}
}

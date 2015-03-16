package br.com.quemquerfazerhistoria.service;

import java.sql.Connection;
import java.util.List;

import br.com.quemquerfazerhistoria.dao.HistoriaGeradaDAO;
import br.com.quemquerfazerhistoria.dao.Nivel1DAO;
import br.com.quemquerfazerhistoria.dao.Nivel2DAO;
import br.com.quemquerfazerhistoria.dao.Nivel3DAO;
import br.com.quemquerfazerhistoria.dao.PersonagemDAO;
import br.com.quemquerfazerhistoria.model.HistoriaGerada;
import br.com.quemquerfazerhistoria.model.Nivel1;
import br.com.quemquerfazerhistoria.model.Nivel2;
import br.com.quemquerfazerhistoria.model.Nivel3;
import br.com.quemquerfazerhistoria.model.Personagem;
import br.com.quemquerfazerhistoria.utils.Log;
import br.com.quemquerfazerhistoria.utils.Utils;

public class GerarHistoriaAleatoriaService {

	private final Connection connection;
	private HistoriaGerada hg;
	
	public GerarHistoriaAleatoriaService(Connection connection) {
		this.connection = connection;
	}
	
	public HistoriaGerada getHistoria()
	{
		try {
			//----------------------
			// Lista de personagens e pega um personagem randomicamente
			//----------------------
			List<Personagem> lstPersonagem = new PersonagemDAO(connection).lista();
			int personagemID = lstPersonagem.get(Utils.getNumRandom(lstPersonagem.size())).getPersonagemid();
		
			//----------------------
			// Lista os inicios e pega um nivel1 randomicamente
			//----------------------
			List<Nivel1> lstNivel1 = new Nivel1DAO(connection).lista(personagemID);
			int nivel1ID = lstNivel1.get(Utils.getNumRandom(lstNivel1.size())).getNivel1id();
			
			//----------------------
			// Lista os meios e pega um nivel2 randomicamente
			//----------------------
			List<Nivel2> lstNivel2 = new Nivel2DAO(connection).lista(nivel1ID);
			int nivel2ID = lstNivel2.get(Utils.getNumRandom(lstNivel2.size())).getNivel2id();
			
			//----------------------
			// Lista os finais e pega um nivel3 randomicamente
			//----------------------
			List<Nivel3> lstNivel3 = new Nivel3DAO(connection).lista(nivel2ID);
			int nivel3ID = lstNivel3.get(Utils.getNumRandom(lstNivel3.size())).getNivel3id();
			
			//----------------------
			// Retorna a história gerada
			//----------------------
			this.hg = new HistoriaGeradaDAO(connection).getHistoria(personagemID, nivel1ID, nivel2ID, nivel3ID);
			carregarChavesNaHistoria(personagemID, nivel1ID, nivel2ID, nivel3ID);
			
			return this.hg;
		} catch (Exception e) {
			Log.setErro("-----------------------");
        	Log.setErro("Gerar Historia aleatoria sem parâmetros");
        	Log.setErro("-----------------------");
        	Log.setErro("0 - " + e.getMessage());
        	
        	return null;
		}
	}

	public int getNivel1ID(int personagemID)
	{
		try {
			//----------------------
			// Lista os inicios e pega um nivel1 randomicamente
			//----------------------
			List<Nivel1> lstNivel1 = new Nivel1DAO(connection).lista(personagemID);
			int nivel1ID = lstNivel1.get(Utils.getNumRandom(lstNivel1.size())).getNivel1id();
			
			return nivel1ID;
		} catch (Exception e) {
			Log.setErro("-----------------------");
        	Log.setErro("Gerar Historia aleatoria com personagemID");
        	Log.setErro("-----------------------");
        	Log.setErro("0 - " + e.getMessage());
        	
        	return 0;
		}
	}
	
	public int getNivel2ID(int personagemID, int nivel1ID)
	{
		try {
			//----------------------
			// Lista os meios e pega um nivel2 randomicamente
			//----------------------
			List<Nivel2> lstNivel2 = new Nivel2DAO(connection).lista(nivel1ID);
			int nivel2ID = lstNivel2.get(Utils.getNumRandom(lstNivel2.size())).getNivel2id();
			
			return nivel2ID;
		} catch (Exception e) {
			Log.setErro("-----------------------");
        	Log.setErro("Gerar Historia aleatoria com personagem e nivel1");
        	Log.setErro("-----------------------");
        	Log.setErro("0 - " + e.getMessage());
        	throw new RuntimeException(e);
		}
	}
	
	public HistoriaGerada getHistoria(int personagemID, int nivel1ID, int nivel2ID)
	{
		try {
			//----------------------
			// Lista os finais e pega um nivel3 randomicamente
			//----------------------
			List<Nivel3> lstNivel3 = new Nivel3DAO(connection).lista(nivel2ID);
			int nivel3ID = lstNivel3.get(Utils.getNumRandom(lstNivel3.size())).getNivel3id();
			
			//----------------------
			// Retorna a história gerada
			//----------------------
			this.hg = new HistoriaGeradaDAO(connection).getHistoria(personagemID, nivel1ID, nivel2ID, nivel3ID);
			carregarChavesNaHistoria(personagemID, nivel1ID, nivel2ID, nivel3ID);
			
			return this.hg;
		} catch (Exception e) {
        	Log.setErro("-----------------------");
        	Log.setErro("Gerar Historia aleatoria com personagem e nivel1 e nivel2");
        	Log.setErro("-----------------------");
        	Log.setErro("0 - " + e.getMessage());
        	
        	return null;
		}
	}

	/**
	 * @param nivel1ID
	 * @param nivel2ID
	 * @param nivel3ID
	 * @param hg
	 */
	public void carregarChavesNaHistoria(int personagemID, int nivel1ID,
			int nivel2ID, int nivel3ID) {
		this.hg.setPersonagemid(personagemID);
		this.hg.setNivel1id(nivel1ID);
		this.hg.setNivel2id(nivel2ID);
		this.hg.setNivel3id(nivel3ID);
	}
}
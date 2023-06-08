package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private static final String NOME = "saluta";
	
	
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if(partita.getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' nessuno in questa stanza!!");
	}
	
	public String getNome() {
		return NOME;
	}
}
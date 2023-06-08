package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido extends AbstractComando{

	private final static String NOME = "non valido";
	
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		io.mostraMessaggio("Comando non valido!! Scrivi il comando 'aiuto' per vedere i comandi");
    }

	public String getNome() {
		return NOME;
	}
}

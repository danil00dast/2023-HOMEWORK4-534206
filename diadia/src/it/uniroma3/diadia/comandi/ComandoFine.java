package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando{

	private final static String NOME = "fine";
	private final static String FINE = "Grazie di aver giocato!!";

	public void esegui(Partita partita) {
		IO io=new IOConsole();
		partita.setFinita();
		io.mostraMessaggio(FINE);
	}

	public String getNome() {
		return NOME;
	}
}
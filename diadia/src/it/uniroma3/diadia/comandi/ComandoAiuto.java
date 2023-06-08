package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	static final public String[] ELENCO_COMANDI = {"Puoi usare i seguenti comandi:\n'vai + destinazione'   'guarda'   'prendi + nome attrezzo'   'posa + nome attrezzo'   'aiuto'   'fine'","\nPer interagire con i personaggi:\n'saluta'   'interagisci'   'regala + nome attrezzo'"};
	private final static String NOME = "aiuto";

	public void esegui(Partita partita) {
		IO io = new IOConsole();
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			io.mostraMessaggio(ELENCO_COMANDI[i]+" ");
		    io.mostraMessaggio("");
    }

	public String getNome() {
		return NOME;
	}
}
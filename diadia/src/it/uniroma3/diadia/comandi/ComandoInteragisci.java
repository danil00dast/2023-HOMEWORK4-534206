package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.*;

public class ComandoInteragisci extends AbstractComando {
	
	private static final String MESSAGGIO_CON_CHI =	"Con chi dovrei interagire?...Non c'è nessuno nella stanza...";
	private static final String NOME = "interagisci";
	private String messaggio;
	
	
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		IO io = new IOConsole();
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);
		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}

	public String getMessaggio() {
		return this.messaggio;
	}

	public String getNome() {
		return NOME;
	}
}
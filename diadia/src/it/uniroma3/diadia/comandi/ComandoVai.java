package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando {
	
	private final static String NOME = "vai";

	public void esegui(Partita partita) {
		IO io = new IOConsole();
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			io.mostraMessaggio("Comando non valido!! Scrivi 'vai + destinazione'");
		}
		if(this.getParametro()!=null)
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				io.mostraMessaggio("Direzione inesistente!!");
				return;
			}
			if (prossimaStanza == null) {
			io.mostraMessaggio("Direzione inesistente!!");
			return;
		}
			partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}

	public String getNome() {
		return NOME;
	}
}
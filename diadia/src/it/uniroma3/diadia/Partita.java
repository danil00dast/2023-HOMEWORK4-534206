package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {
	
	private Giocatore giocatore;
	private Labirinto labirinto;
	private boolean finita;

	public Partita(Labirinto labirinto){
		giocatore = new Giocatore();
		this.labirinto = labirinto;
		this.finita = false;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}
	
	public void setFinita() {
		this.finita = true;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.getLabirinto().setStanzaCorrente(stanzaCorrente);
	}
	
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}
	
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCfu()>0;
	}
	
	public Labirinto getLabirinto(){
		return labirinto;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}
	
	public Stanza getStanzaCorrente() {
		return this.getLabirinto().getStanzaCorrente();
	}
}

package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Configuratore;

public class Giocatore {
	
	static final private int CFU_INIZIALI = Configuratore.getCFU();
	private int cfu;
	private Borsa borsa;

	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}	
	
	public int getCfu() {
		return this.cfu;
	}

	public Borsa getBorsa() {
		return borsa;
	}
}

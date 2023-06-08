package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{

	private String parametro;
	
	public String getParametro() {
		return this.parametro;
	}
	
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}
	
	abstract public String getNome();
	
	abstract public void esegui(Partita partita);
	
}

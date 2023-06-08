package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{

	private String nomeAttrezzo;
	private final static String NOME = "prendi";

	public void esegui(Partita partita) {
		IO io = new IOConsole();
		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("Ho preso dalla stanza l'attrezzo " +a+ " e l'ho messo nella borsa");
		} 
		else {
			io.mostraMessaggio("Comando non valido!! Per prendere un attrezzo inserire 'prendi + nome attrezzo'");
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
    }
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	public String getNome() {
		return NOME;
	}
}

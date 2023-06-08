package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando {
	private static final String NOME ="regala";
	private String nomeAttrezzo;
	
    @Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(partita.getGiocatore().getBorsa().isEmpty())
		   io.mostraMessaggio("Non posso regalare niente...!!");
		else if(partita.getStanzaCorrente().hasPersonaggio()) {
		io.mostraMessaggio(partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita));
		partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
		}
		else
			io.mostraMessaggio("Non c'è nessuno in questa stanza...");
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
}
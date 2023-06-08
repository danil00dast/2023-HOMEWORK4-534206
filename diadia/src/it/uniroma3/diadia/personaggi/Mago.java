package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
		}
	
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		IO io = new IOConsole();
		if(attrezzo!=null ) {
		io.mostraMessaggio("Che gentile!! Mi hai donato: "+attrezzo.getNome());
		Attrezzo attrezzoMeta = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoMeta);
		return "Credo però sia più utile a te.\nLo renderò meno pesante\nRaccoglilo pure!!";
		}
		else 
			return "Comando non valido!! Scrivi 'regala + nome attrezzo'";
	}
}

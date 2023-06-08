package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private static String MESSAGGIO_CANE = "Aia il cane ti ha morso :( Hai perso un CFU!!";
	private static String CIBO = "osso";
	
	public Cane (String nome, String presentaz) {
		super(nome, presentaz);
		}
	
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return MESSAGGIO_CANE;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if(attrezzo !=null && attrezzo.getNome().equals(CIBO)) {
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("catena", 3));
			return "Grazie!! Mi hai dato il mio cibo preferito, bauuu bauuu!!";
		}
		else if(attrezzo==null) 
			return "Comando non valido!! Scrivi 'regala + nome attrezzo'";
		else {
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
			return "NON E' IL MIO CIBO PREFERITO BAUUU!!\nIl cane ti ha morso, hai perso un CFU...";
	   }
    }
}


package it.uniroma3.diadia.personaggi;

import java.util.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato, non ti mando in uno scantinato!!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!!";

	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}
	
	public String agisci(Partita partita) {
		String msg;
		Map<Direzione, Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getMapStanzeAdiacenti();

		Stanza maxAtrezzi = stanzeAdiacenti.values().iterator().next();
		Stanza minAtrezzi = stanzeAdiacenti.values().iterator().next();

		for(Stanza s : stanzeAdiacenti.values()) {
			if(s != null) {
				if(s.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = s;
				if(s.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = s;
			}
		}

		if(this.haSalutato()) {
			partita.setStanzaCorrente(maxAtrezzi);
			msg = MESSAGGIO_SALUTATA;
		} else {
			partita.setStanzaCorrente(minAtrezzi);
			msg = MESSAGGIO_NON_SALUTATA;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo != null) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return "AHAHAHAHAHAH";
		}
		else
			return "Comando non valido!! Scrivi 'regala + nome attrezzo'";
	}
}
package it.uniroma3.diadia.ambienti;

import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.*;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO 
 * @see Attrezzo
 * @version base
 */

public class Stanza {

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;

	private String nome;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi=0;
	private int numeroStanzeAdiacenti=0;
	private Map<Direzione, Stanza> stanzeAdiacenti;
	private AbstractPersonaggio personaggio;
	
	public Stanza(String nome) {
		this.nome = nome;
		this.stanzeAdiacenti = new HashMap<>();
		this.attrezzi = new HashMap<>();
	}

	public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
		boolean a = false;
		if (stanzeAdiacenti.containsKey(direzione)) {
			this.stanzeAdiacenti.put(direzione,stanza);
			a = true;
		}
		if (!a)
			if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
				this.stanzeAdiacenti.put(direzione,stanza);
				this.numeroStanzeAdiacenti++;
			}
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null && this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI && !this.attrezzi.containsKey(attrezzo.getNome())) {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		boolean trovato = false;
		Attrezzo attrezzoCercato = null;
		if(this.attrezzi.size()>=1) {
			attrezzoCercato=this.attrezzi.remove(attrezzo.getNome());
			if(attrezzoCercato!=null) {
				trovato=true;
			}
		}
		return trovato;
	}

	public void setNumeroAttrezzi(int numeroAttrezzi) {
		this.numeroAttrezzi = numeroAttrezzi;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) {	
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	public boolean hasPersonaggio() {
	    return this.personaggio != null;
	}
	
	public void setStanzeAdiacenti(Map<Direzione, Stanza> stanzeAdiacenti) {
		this.stanzeAdiacenti = stanzeAdiacenti;
	}
	
	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}
	
	public void setPersonaggio(AbstractPersonaggio a) {
		this.personaggio = a;
	}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
	}
	
	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}
	
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescrizione() {
		return this.toString();
	}
	
	public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}
	
	public List<Stanza> getStanzeAdiacenti() {
		List<Stanza> listaStanzeAdiacenti = new ArrayList<>();
		for (Stanza s : stanzeAdiacenti.values()) {
			listaStanzeAdiacenti.add(s);
		}
		return listaStanzeAdiacenti;
	}

	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;
		if (this.stanzeAdiacenti.containsKey(direzione))
			stanza = this.stanzeAdiacenti.get(direzione);
		return stanza;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	public Set<Direzione> getDirezioni() {
		return stanzeAdiacenti.keySet();
	}

	public Map<Direzione,Stanza> getMapStanzeAdiacenti(){
		return this.stanzeAdiacenti;
	}
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append("\nStanza Corrente: "+this.nome);
		risultato.append("\nUscite: ");
		for (Direzione direzione : this.stanzeAdiacenti.keySet())
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
          for(Attrezzo a : this.attrezzi.values()) {
			risultato.append(a.toString()+"");
		}
          if(this.getPersonaggio()==null)
          	risultato.append("\n\nNon c'e' nessuno in questa stanza...\n");
          else
          	risultato.append("\n\nIn questa stanza c'e' qualcuno!!\n'saluta'   'interagisci'   'regala + nome attrezzo'\n");

		return risultato.toString();
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode()+this.getAttrezzi().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Stanza that = (Stanza)obj;
		return this.getNome().equals(that.getNome()) && this.getAttrezzi().equals(that.getAttrezzi());
	}
}
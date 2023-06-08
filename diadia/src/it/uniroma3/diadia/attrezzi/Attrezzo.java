package it.uniroma3.diadia.attrezzi;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	@Override
	public int compareTo(Attrezzo that) {
		if(this.getPeso()-that.getPeso()!=0)
			return this.getPeso()-that.getPeso();
		else
			return this.getNome().compareTo(that.getNome());
	}

	@Override
	public int hashCode() {
		return this.getPeso()+this.getNome().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Attrezzo that = (Attrezzo)obj;
		return this.getPeso()==that.getPeso()&&this.getNome().equals(that.getNome());
	}
	
	public String getNome() {
		return this.nome;
	}

	public int getPeso() {
		return this.peso;
	}
}
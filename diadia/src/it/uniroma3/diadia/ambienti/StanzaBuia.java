package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String oggettoLucente;
	
	public StanzaBuia(String nome,String oggetto) {
		super(nome);
		this.oggettoLucente = oggetto;
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(oggettoLucente))
			return "Qui c'e' un buio pesto\nMeglio fare luce con un attrezzo, magari con: "+this.oggettoLucente;
		else
			return super.getDescrizione();
	}
}
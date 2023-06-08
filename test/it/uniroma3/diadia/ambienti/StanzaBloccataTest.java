package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

	private StanzaBloccata stanzabloccata;
	private Stanza stanza;
	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		stanzabloccata = new StanzaBloccata("StanzaBloccata", Direzione.ovest, "chiave");
		stanza = new Stanza("Stanza");
		attrezzo = new Attrezzo("chiave", 1);
		stanzabloccata.impostaStanzaAdiacente(Direzione.ovest, stanza);
	}

	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzabloccata, stanzabloccata.getStanzaAdiacente(Direzione.ovest));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneSbloccata() {
		stanzabloccata.addAttrezzo(attrezzo);
		assertEquals(stanza, stanzabloccata.getStanzaAdiacente(Direzione.ovest));
	}

	@Test
	public void testGetDescrizioneDirezioneSbloccata() {
		stanzabloccata.addAttrezzo(attrezzo);
		assertEquals(stanzabloccata.toString(), stanzabloccata.getDescrizione());
	}
}

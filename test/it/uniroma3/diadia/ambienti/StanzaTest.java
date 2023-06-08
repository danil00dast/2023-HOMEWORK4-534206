package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import org.junit.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {	

	Stanza stanza1 = new Stanza("s1");
	Stanza stanza2= new Stanza("s2");
	Attrezzo m = new Attrezzo("spada", 10);

	@Test
	public void testImpostaStanzaAdiacente() {
		stanza1.impostaStanzaAdiacente(Direzione.sud, stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(stanza1.addAttrezzo(m));
	}
}

package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import static org.junit.Assert.*;
import org.junit.*;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo lanterna;
	private Attrezzo pistola;
	
	@Before
	public void setUp() {
		stanza = new StanzaBuia("StanzaBuia", "lanterna");
		lanterna = new Attrezzo("lanterna", 3);
		pistola = new Attrezzo("pistola", 2);
	}
	
	@Test
	public void testGetDescrizioneNonBuio() {
		stanza.addAttrezzo(lanterna);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}

	@Test
	public void testGetDescrizioneBuio() {
		stanza.addAttrezzo(pistola);
		String DescrizioneBuio = "Qui c'e' un buio pesto\nMeglio fare luce con un attrezzo, magari con: lanterna";
		assertEquals(DescrizioneBuio, stanza.getDescrizione());
	}

}
package it.uniroma3.diadia;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;
import it.uniroma3.diadia.ambienti.*;

public class PartitaTest {

	Labirinto labirinto;
	Partita partita;
	Stanza stanza;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 partita = new Partita(labirinto);
		 stanza = new Stanza("Stanza");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testIsFinita() {
		assertFalse(partita.isFinita());
	}
}

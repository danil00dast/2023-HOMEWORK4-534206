package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;
import it.uniroma3.diadia.FormatoFileNonValidoException;

public class LabirintoTest {
	Labirinto labirinto;
	Stanza biblioteca;
	Stanza N10;

	@Before
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		 biblioteca = new Stanza("Biblioteca");
		 N10 = new Stanza("N10");
		}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		labirinto.setStanzaCorrente(N10);
		assertEquals(N10, labirinto.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
}

package it.uniroma3.diadia;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	private CaricatoreLabirinto c;
	
	private final String monolocale = 
			"Stanze:biblioteca\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:N12\n"+
			"Vincente:N11\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:fune 2 N12\n"+
			"Uscite:\n";
	
	@Test
	public void testMonolocale() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(new StringReader(monolocale));
		c.carica();
		assertEquals("biblioteca", this.c.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.c.getStanzaVincente().getNome());
		}
	
	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(new StringReader(bilocale));
		c.carica();
		assertEquals("N12", this.c.getStanzaIniziale().getNome());
		assertEquals("N11", this.c.getStanzaVincente().getNome());
		}
	
	
	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(new StringReader(bilocale));
		c.carica();
		Attrezzo expected = new Attrezzo("fune", 2);
		assertEquals(expected, this.c.getStanzaIniziale().getAttrezzo("fune"));
		}
}

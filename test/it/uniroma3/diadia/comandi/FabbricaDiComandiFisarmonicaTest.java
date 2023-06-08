package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import org.junit.*;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonicaTest {

	private FabbricaDiComandiFisarmonica fabbrica;
	@SuppressWarnings("unused")
	private IO io;
	private Comando expected;
	
	@Before
	public void setUp() throws Exception {
		io = new IOConsole();
		fabbrica = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("boh").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("nord");
		Comando current = fabbrica.costruisciComando("vai nord");
		assertEquals( expected.getNome(), current.getNome());
		assertEquals( expected.getParametro(), current.getParametro());
	}
	
	@Test
	public void testComandoSenzaParametro() {
		expected = new ComandoFine();
		assertEquals( expected.getNome(), fabbrica.costruisciComando("fine").getNome());
	}

}

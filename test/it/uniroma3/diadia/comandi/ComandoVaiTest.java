package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;


public class ComandoVaiTest {

	private Stanza stanza1;
	private Stanza stanza2;
	private Comando vai;
	private Partita partita;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;

	@Before
	public void setUp() throws Exception {
		stanza1 = new Stanza("aula 1");
		stanza2 = new Stanza("aula 2");
		vai = new ComandoVai();
		labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		partita = new Partita(labirinto);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();

	}

	@Test
	public void testVaiNull() {
		partita.setStanzaCorrente(stanza1);
		vai.esegui(partita);
		assertEquals(stanza1, partita.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		partita.setStanzaCorrente(stanza1);
		stanza1.impostaStanzaAdiacente(Direzione.sud, stanza2);
		vai.setParametro("sud");
		vai.esegui(partita);
		assertEquals(stanza2, partita.getStanzaCorrente());
	}

}



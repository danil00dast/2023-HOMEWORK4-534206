package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

    private Borsa borsa;

    @Before
    public void setUp() {
        borsa = new Borsa(20);
    }

    @Test
    public void testAddAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("martello", 5);
        Attrezzo attrezzo2 = new Attrezzo("cacciavite", 3);
        assertTrue(borsa.addAttrezzo(attrezzo1));
        assertTrue(borsa.addAttrezzo(attrezzo2));
    }

    @Test
    public void testGetAttrezzo() {
        Attrezzo attrezzo1 = new Attrezzo("martello", 5);
        Attrezzo attrezzo2 = new Attrezzo("cacciavite", 3);
        borsa.addAttrezzo(attrezzo1);
        borsa.addAttrezzo(attrezzo2);
        assertEquals(attrezzo1, borsa.getAttrezzo("martello"));
        assertEquals(attrezzo2, borsa.getAttrezzo("cacciavite"));
    }

    @Test
    public void testPesoMax() {
    	 assertEquals(20, borsa.getPesoMax());
    }
}
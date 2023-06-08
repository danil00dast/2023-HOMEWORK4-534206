package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import org.junit.*;

public class GiocatoreTest {

    private Giocatore giocatore;

    @Before
    public void setUp() {
        giocatore = new Giocatore();
    }

    @Test
    public void testGetCfu() {
        int cfu = giocatore.getCfu();
        assertEquals(20, cfu);
    }

    @Test
    public void testSetCfu() {
        giocatore.setCfu(10);
        int cfu = giocatore.getCfu();
        assertEquals(10, cfu);
    }

    @Test
    public void testGetBorsa() {
        Borsa borsa = giocatore.getBorsa();
        assertEquals(0, borsa.getPeso());
    }
}
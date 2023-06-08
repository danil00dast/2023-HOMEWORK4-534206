package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import org.junit.*;
import static org.junit.Assert.*;

public class AbstractComandoTest {

    private AbstractComandoStub comando;

    @Before
    public void setUp() {
        comando = new AbstractComandoStub();
    }

    @Test
    public void testGetParametro() {
        comando.setParametro("parametro di prova");
        assertEquals("parametro di prova", comando.getParametro());
    }

    @Test
    public void testSetParametro() {
        comando.setParametro("nuovo parametro");
        assertEquals("nuovo parametro", comando.getParametro());
    }

    @Test
    public void testGetNome() {
        assertEquals("ComandoStub", comando.getNome());
    }

    private static class AbstractComandoStub extends AbstractComando {

        @Override
        public String getNome() {
            return "ComandoStub";
        }

		@Override
		public void esegui(Partita partita) {
			}
		}
}

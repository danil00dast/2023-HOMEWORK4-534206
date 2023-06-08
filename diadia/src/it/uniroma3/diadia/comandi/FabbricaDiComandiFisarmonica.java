package it.uniroma3.diadia.comandi;

import java.util.Scanner;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	@Override
	public Comando costruisciComando(String istruzione) {
		@SuppressWarnings("unused")
		IO io= new IOConsole();
		@SuppressWarnings("resource")
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); 
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("saluta"))
			comando = new ComandoSaluta();
		else if (nomeComando.equals("interagisci"))
			comando = new ComandoInteragisci();
		else if (nomeComando.equals("regala"))
			comando = new ComandoRegala();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
	}
}

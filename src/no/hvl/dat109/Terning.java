/**
 * 
 */
package no.hvl.dat109;

import java.util.Random;

/**
 * @author Marcus
 *
 */
public class Terning {
	public Dyr[] terning;
	private Random random = new Random();
	private Dyr love = new Dyr("løve", "Oransje", 1);
	private Dyr slange = new Dyr("slange", "Grønn", 2);
	private Dyr panda = new Dyr("panda", "Svart", 3);
	private Dyr gris = new Dyr("gris", "Rosa", 4);
	private Dyr elefant = new Dyr("elefant", "Grå", 5);
	private Dyr hval = new Dyr("hval", "Blå", 6);
	
	
	/**
	 * Oppretter ny terning
	 */
	public Terning() {
		terning = new Dyr[6];
		terning[0] = love;
		terning[1] = slange;
		terning[2] = panda;
		terning[3] = gris;
		terning[4] = elefant;
		terning[5] = hval;
	}
	
	/**
	 * Triller terningen og returnerer et dyr-objekt
	 * @return et tilfeldig dyr-objekt
	 */
	public Dyr trillTerning() {
		int resultat = random.nextInt(6);
		return terning[resultat];
	}
	
}

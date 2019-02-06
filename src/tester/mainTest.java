/**
 * 
 */
package tester;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.Blokk;
import no.hvl.dat109.Dyr;
import no.hvl.dat109.Spiller;
import no.hvl.dat109.Terning;

/**
 * @author Sivert
 *
 */
public class mainTest {
	ArrayList<Dyr> terninger = new ArrayList<Dyr>();
	Spiller spiller1 = new Spiller("A");
	Spiller spiller2 = new Spiller("B");
	Spiller[] spillere = new Spiller[2];
	Blokk blokk;
	Terning terning = new Terning();
	Dyr love = new Dyr("løve", "Oransje", 1);
	Dyr slange = new Dyr("slange", "Grønn", 2);
	Dyr panda = new Dyr("panda", "Svart", 3);
	Dyr gris = new Dyr("gris", "Rosa", 4);
	Dyr elefant = new Dyr("elefant", "Grå", 5);
	Dyr hval = new Dyr("hval", "Blå", 6);
	final int runde6 = 6;
	final int runde7 = 7;
	final int runde8 = 8;
	final int runde9 = 9;
	final int runde10 = 10;
	final int runde11 = 11;
	final int runde12 = 12;
	
	@Before
	public void setup() {
		spillere[0] = spiller1;
		spillere[1] = spiller2;
		blokk = new Blokk(spillere);
	}
	
	/**
	 * Tester om sjekk på resultat for hver runde er riktig
	 */
	@Test
	public void rundeTest() {
		//Runde 1-6 kan sjekkes i én sjekk
		Dyr dyr1 = love;
		Dyr dyr2 = slange;
		Dyr dyr3 = gris;
		Dyr dyr4 = hval;
		Dyr dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		int sjekk = blokk.getRad().rundeSjekk(runde6, terninger);
		Assert.assertEquals(2, sjekk);
		terninger = new ArrayList<Dyr>();
		
		//Sjekker runde 7. 3 like
		dyr1 = love;
		dyr2 = hval;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde7, terninger);
		Assert.assertEquals(3, sjekk);
		terninger = new ArrayList<Dyr>();
		
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde7, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 8. 4 like
		dyr1 = gris;
		dyr2 = gris;
		dyr3 = hval;
		dyr4 = gris;
		dyr5 = gris;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde8, terninger);
		Assert.assertEquals(4, sjekk);
		terninger = new ArrayList<Dyr>();
				
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde8, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 9. 2 par
		dyr1 = slange;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde9, terninger);
		Assert.assertEquals(4, sjekk);
		terninger = new ArrayList<Dyr>();
				
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde9, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 10. Fullt hus
		dyr1 = love;
		dyr2 = love;
		dyr3 = love;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde10, terninger);
		Assert.assertEquals(5, sjekk);
		terninger = new ArrayList<Dyr>();
				
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde10, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 11. Alle ulike
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = elefant;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde11, terninger);
		Assert.assertEquals(5, sjekk);
		terninger = new ArrayList<Dyr>();
				
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde11, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
		//Sjekker runde 12. Alle like
		dyr1 = slange;
		dyr2 = slange;
		dyr3 = slange;
		dyr4 = slange;
		dyr5 = slange;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde12, terninger);
		Assert.assertEquals(10, sjekk);
		terninger = new ArrayList<Dyr>();
				
		dyr1 = love;
		dyr2 = slange;
		dyr3 = gris;
		dyr4 = hval;
		dyr5 = hval;
		terninger.add(dyr1);
		terninger.add(dyr2);
		terninger.add(dyr3);
		terninger.add(dyr4);
		terninger.add(dyr5);
		sjekk = blokk.getRad().rundeSjekk(runde12, terninger);
		Assert.assertEquals(0, sjekk);
		terninger = new ArrayList<Dyr>();
				
	}
	
	/**
	 * Tester om trillTerning() returnerer et dyr.
	 */
	@Test
	public void terningTest() {
		Dyr dyr = terning.trillTerning();
		Assert.assertNotNull(dyr);
	}
	
	/**
	 * Tester om mapAntall() gir en korrekt mapping av dyr og forekomsten av det dyret.
	 */
	@Test
	public void mapTest() {
		terninger.add(love);
		terninger.add(love);
		terninger.add(slange);
		terninger.add(panda);
		terninger.add(panda);
		terninger.add(panda);
		terninger.add(elefant);
		terninger.add(hval);
		terninger.add(hval);
		terninger.add(hval);
		terninger.add(hval);
		
		Map<Dyr, Integer> testMap = blokk.getRad().mapAntall(terninger);
		int antallLover = testMap.get(love);
		Assert.assertEquals(2, antallLover);
		int antallSlanger = testMap.get(slange);
		Assert.assertEquals(1, antallSlanger);
		int antallPandaer = testMap.get(panda);
		Assert.assertEquals(3, antallPandaer);
		int antallElefanter = testMap.get(elefant);
		Assert.assertEquals(1, antallElefanter);
		int antallHvaler = testMap.get(hval);
		Assert.assertEquals(4, antallHvaler);
		int antallGriser;
		try {
			antallGriser = testMap.get(gris);
		} catch (NullPointerException e) {
			antallGriser = 0;
		}
		Assert.assertEquals(0, antallGriser);
		
		
	}
	
	/**
	 * Tester om summerpoeng() angir riktig poengsum til spilleren.
	 */
	@Test
	public void summerPoengTest() {
		spiller1.getKolonne().oppdaterVerdi(1, 1);
		spiller1.getKolonne().oppdaterVerdi(2, 2);
		spiller1.getKolonne().oppdaterVerdi(3, 3);
		spiller1.getKolonne().oppdaterVerdi(4, 4);
		spiller2.getKolonne().oppdaterVerdi(1, 2);
		spiller2.getKolonne().oppdaterVerdi(2, 3);
		spiller2.getKolonne().oppdaterVerdi(3, 4);
		spiller2.getKolonne().oppdaterVerdi(4, 5);
		spiller1.summerPoeng();
		spiller2.summerPoeng();
		int spiller1sum = spiller1.getPoengscore();
		int spiller2sum = spiller2.getPoengscore();
		Assert.assertEquals(10, spiller1sum);
		Assert.assertEquals(14, spiller2sum);
	}

}

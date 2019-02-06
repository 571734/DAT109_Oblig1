/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Sivert
 *
 */
public class Yatzoo {
	private int runde;
	public Terning terning;
	public ArrayList<Dyr> terningkast;
	private Scanner tastatur = new Scanner(System.in);
	private Blokk blokk;
	public Spiller[] spillere;

	public Yatzoo(Spiller[] spillere) {
		runde = 1;
		terning = new Terning();
		terningkast = new ArrayList<Dyr>();
		blokk = new Blokk(spillere);
		this.spillere = spillere;
	}
	
	/**
	 * Starter selve spillet, med antall ønskede runder som parameter.
	 * @param i - angir hvor mange runder som skal spilles
	 */
	public void spill(int i) {
		while (runde <= i) {
			spillRunde();
		}
		for (Spiller s : spillere) {
			s.summerPoeng();
		}
		finnVinner();
	}
	
	/**
	 * Bruker kastTerninger() for å spille én runde for alle spillere.
	 */
	public void spillRunde() {
		for (Spiller spiller : spillere) {
			System.out.println("\n" + spiller.getNavn() + " sin tur."
						+ "\nDenne runden skal du ha " + blokk.getRad().getRad()[runde-1].getBeskrivelse());
			kastTerninger();
			int resultat = blokk.getRad().rundeSjekk(runde, terningkast);
			spiller.getKolonne().oppdaterVerdi(runde, resultat);
			terningkast.clear();
		}
		runde++;
	}

	/**
	 * Metoden tar for seg hele turen til én spiller. Den kaster terningene, sjekker hvilke terninger 
	 * spilleren vil beholde og kaster de andre på nytt.
	 */
	public void kastTerninger() {
		int antall = 5;
		boolean ferdig = false;
		int count = 0;
		while (!ferdig && count < 3) {
			for (int i = 0; i < antall; i++) {
				Dyr dyr = terning.trillTerning();
				terningkast.add(dyr);
			}
			System.out.println("\nDine terninger:");
			for (int i = 1; i < 6; i++) {
				System.out.println(i + ".\t" + terningkast.get(i - 1));
			}
			if (count != 2) {
				System.out.println(
						"\nSkriv inn tallene på terningene du ønsker å beholde, skilt med mellomrom.\nEks: '1 4 5' (Triller 2 og 3 på nytt)");
				String[] inputTab = null;
				int tablengde = 0;
				boolean gyldigeTerninger = false;
				while (!gyldigeTerninger) {
					String input = tastatur.nextLine();
					inputTab = input.split("\\s+");
					if (input.equals("") || input.equals(" ")) {
						tablengde = 0;
					} else {
						tablengde = inputTab.length;
					} 
					gyldigeTerninger = isTerningvalgGyldig(inputTab);
				}
				ArrayList<Dyr> midlertidig = new ArrayList<Dyr>();
				for (int i = 0; i < tablengde; i++) {
					midlertidig.add(terningkast.get(Integer.parseInt(inputTab[i]) - 1));
				}
				terningkast = midlertidig;
			}
			antall = 5 - terningkast.size();
			if (antall == 0) {
				ferdig = true;
			}
			
			count++;
		}
	}
	
	/**
	 * Skriver ut spiller(ne) med høyest poengsum.
	 */
	public void finnVinner() {
		boolean flereVinnere = false;
		Spiller vinner = spillere[0];
		ArrayList<Spiller> vinnere = new ArrayList<Spiller>();
		vinnere.add(vinner);
		for (int i = 1; i < spillere.length; i++) {
			if (spillere[i].getPoengscore() > vinner.getPoengscore()) {
				vinner = spillere[i];
				if (flereVinnere) {
					flereVinnere = false;
					vinnere.clear();
				}
			} else if (spillere[i].getPoengscore() == vinner.getPoengscore()) {
				flereVinnere = true;
				vinnere.add(spillere[i]);
			}
		}
		System.out.println("\nResultatliste:");
		for (Spiller s : spillere) {
			System.out.println(s.getNavn() + "\t:\t" + s.getPoengscore() + "p");
		}
		if (flereVinnere) {
			System.out.print("\nDet er flere spillere med like stor poengsum som deler 1. plassen.\nGratulerer");
			for (Spiller s : vinnere) {
				System.out.print("  " + s.getNavn());
			}
			System.out.println("!");
		} else {
			System.out.println("Gratulerer " + vinner.getNavn() + "! Du har vunnet spillet!");
		}
	}
	
	/**
	 * Hjelpemetode for å sjekke om angitte terninger, spilleren ønsker å beholde, er gyldig input.
	 * @param terninger - stringtabell med terningene 
	 * @return True dersom input er gyldig, false ellers.
	 */
	public boolean isTerningvalgGyldig(String[] terninger) {
		for (int i = 0; i < terninger.length; i++) {
			try {
				int a = Integer.parseInt(terninger[i]);
				if (!(a > 0) || !(a < 6)) {
					System.out.println("Du har skrevet et tall utenfor tallene 1-5. Prøv igjen.");
					return false;
				}
			} catch (Exception e) {
				System.out.println("Her kan du kun skrive tall, skilt med mellomrom.");
				return false;
			}
		}
		return true;
	}

	public int getRunde() {
		return runde;
	}

	public ArrayList<Dyr> getTerningkast() {
		return terningkast;
	}

	public Blokk getBlokk() {
		return blokk;
	}
	
	

}

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
	
	public void spill(int i) {
		while (runde <= i) {
			spillRunde();
		}
		for (Spiller s : spillere) {
			summerPoeng(s);
		}
		finnVinner();
	}
	
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
				String input = tastatur.nextLine();
				String[] inputTab = input.split("\\s+");
				int tablengde;
				if (input.equals("") || input.equals(" ")) {
					tablengde = 0;
				} else {
					tablengde = inputTab.length;
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
	
	public void summerPoeng(Spiller spiller) {
		int sum = 0;
		for (int i : spiller.getKolonne().getKolonne()) {
			sum += i;
		}
		spiller.setPoengscore(sum);
	}
	
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

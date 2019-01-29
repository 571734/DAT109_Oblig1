package no.hvl.dat109;

import java.util.Scanner;

public class Observator {

	public static void main(String[] args) {
		try {
			Scanner tastatur = new Scanner(System.in);
			System.out.println("\nHvor mange spillere? (Maks 5)");
			int antSpillere = Integer.parseInt(tastatur.nextLine());
			if (antSpillere < 2 || antSpillere > 5) {
				System.out.println("Ugyldig antall spillere. Spillet avsluttes.");
				
			}
			Spiller[] spillere = new Spiller[antSpillere];
			for (int i = 0; i < antSpillere; i++) {
				System.out.print("\nNavn på spiller " + (i + 1) + ":\t");
				String navn = tastatur.nextLine();
				Spiller spiller = new Spiller(navn);
				spillere[i] = spiller;
			}

			Yatzoo yatzoo = new Yatzoo(spillere);

			System.out.println("\nHvor mange runder? (Maks 12)");
			int runde = Integer.parseInt(tastatur.nextLine());
			yatzoo.spill(runde);
			tastatur.close();
		} catch (Exception e) {
			System.out.println("-----Dette er utilsiktet bruk-----");
			e.printStackTrace();
		}

	}

}

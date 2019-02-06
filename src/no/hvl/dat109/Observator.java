package no.hvl.dat109;

import java.util.Scanner;

public class Observator {

	public static void main(String[] args) {
		try {
			Scanner tastatur = new Scanner(System.in);
			System.out.println("\nHvor mange spillere? (2-5 spillere)");
			boolean lovligAntall = false;
			int antSpillere = 0;
			while (!lovligAntall) {

				try {
					antSpillere = Integer.parseInt(tastatur.nextLine());
					if (antSpillere < 2 || antSpillere > 5) {
						System.out.println("Ugyldig antall spillere. Kun 2-5 spillere.");
					} else {
						lovligAntall = true;
					}
				} catch (Exception e) {
					System.out.println("Dette er ikke et tall. Prøv igjen.");
				}

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
			boolean lovligRunde = false;
			int runde = 0;
			while (!lovligRunde) {
				try {
					runde = Integer.parseInt(tastatur.nextLine());
					if (runde < 1 || runde > 12) {
						System.out.println("Du kan ha et sted mellom 1 og 12 runder. Ikke mer, ikke mindre.");
					} else {
						lovligRunde = true;
					}
				} catch (Exception e) {
					System.out.println("Dette er ikke et tall. Prøv igjen.");
				}
			}
			yatzoo.spill(runde);
			tastatur.close();
		} catch (Exception e) {
			System.out.println("-----Dette er utilsiktet bruk-----");
			e.printStackTrace();
		}

	}

}

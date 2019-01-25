package no.hvl.dat109;

public class Observator {

	public static void main(String[] args) {
		Spiller[] spillere;
		Spiller spiller1 = new Spiller("Arne");
		Spiller spiller2 = new Spiller("Are");
		Spiller spiller3 = new Spiller("Sivert");
		spillere = new Spiller[3];
		spillere[0] = spiller1;
		spillere[1] = spiller2;
		spillere[2] = spiller3;
		Yatzoo yatzoo = new Yatzoo(spillere);
		try {
		yatzoo.spill();
		} catch (Exception e) {
			System.out.println("-----Dette er utilsiktet bruk og vil ikke tolereres-----");
		}
	}

}

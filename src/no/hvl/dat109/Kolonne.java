package no.hvl.dat109;

/**
 * @author Sivert
 *
 */
public class Kolonne {
	private int kolonneId;
	public int[] kolonne;
	
	public Kolonne(int id) {
		kolonneId = id;
		kolonne = new int[12];
	}
	
	public void oppdaterVerdi(int runde, int verdi) {
		kolonne[runde-1] = verdi;
	}

	public int getKolonneId() {
		return kolonneId;
	}

	public void setKolonneId(int kolonneId) {
		this.kolonneId = kolonneId;
	}

	public int[] getKolonne() {
		return kolonne;
	}

	public void setKolonne(int[] kolonne) {
		this.kolonne = kolonne;
	}
	
}

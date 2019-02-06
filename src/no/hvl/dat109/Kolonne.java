package no.hvl.dat109;

/**
 * @author Marcus
 *
 */
public class Kolonne {
	private int kolonneId;
	public int[] kolonne;
	
	public Kolonne(int id) {
		kolonneId = id;
		kolonne = new int[12];
	}
	
	/**
	 * Oppdaterer verdien for en enkelt spiller i en angitt runde.
	 * @param runde - runden som skal ha ny verdi
	 * @param verdi - den nye verdien
	 */
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

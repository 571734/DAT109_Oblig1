/**
 * 
 */
package no.hvl.dat109;

/**
 * @author Marcus
 *
 */
public class Blokk {
	public Kolonne[] kolonner;
	private Rad rad;
	
	public Kolonne kolonne1 = new Kolonne(1);
	public Kolonne kolonne2 = new Kolonne(2);
	public Kolonne kolonne3 = new Kolonne(3);
	public Kolonne kolonne4 = new Kolonne(4);
	public Kolonne kolonne5 = new Kolonne(5);
	
	public Blokk(Spiller[] spillere) {
		rad = new Rad();
		kolonner = new Kolonne[5];
		kolonner[0] = kolonne1;
		kolonner[1] = kolonne2;
		kolonner[2] = kolonne3;
		kolonner[3] = kolonne4;
		kolonner[4] = kolonne5;
		tildelRader(spillere);
	}

	/**
	 * Tildeler én kolonne til hver av spillerne
	 * @param spillere - liste av alle spillere
	 */
	public void tildelRader(Spiller[] spillere) {
		for (int i = 0; i < spillere.length; i++) {
			spillere[i].setKolonne(kolonner[i]);
		}
	}
	
	public Kolonne[] getKolonner() {
		return kolonner;
	}

	public void setKolonner(Kolonne[] kolonner) {
		this.kolonner = kolonner;
	}

	public Rad getRad() {
		return rad;
	}

	public void setRad(Rad rad) {
		this.rad = rad;
	}
	
	
	

}


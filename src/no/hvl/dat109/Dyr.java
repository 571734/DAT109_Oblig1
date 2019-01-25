package no.hvl.dat109;

/**
 * @author Sivert
 *
 */
public class Dyr {
	private String navn;
	private String farge;
	private int id;
	
	public Dyr(String navn, String farge, int id) {
		super();
		this.navn = navn;
		this.farge = farge;
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public String getFarge() {
		return farge;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return farge + " " + navn;
	}
	
}

/**
 * 
 */
package no.hvl.dat109;

/**
 * @author Marcus
 *
 */
public class Runde {
	
	private int rundeId;
	private String beskrivelse;
	
	public Runde(int id, String beskrivelse) {
		rundeId = id;
		this.beskrivelse = beskrivelse;
	}

	public int getRundeId() {
		return rundeId;
	}

	public void setRundeId(int rundeId) {
		this.rundeId = rundeId;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	
}

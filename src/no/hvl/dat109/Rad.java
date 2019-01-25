/**
 * 
 */
package no.hvl.dat109;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sivert
 *
 */
public class Rad {
	public Runde[] rad;
	
	private Runde runde1 = new Runde(1 ,"Løver");
	private Runde runde2 = new Runde(2 ,"Slanger");
	private Runde runde3 = new Runde(3 ,"Pandaer");
	private Runde runde4 = new Runde(4 ,"Griser");
	private Runde runde5 = new Runde(5 ,"Elefanter");
	private Runde runde6 = new Runde(6 ,"Hvaler");
	private Runde runde7 = new Runde(7 ,"3 like");
	private Runde runde8 = new Runde(8 ,"4 like");
	private Runde runde9 = new Runde(9 ,"2 par");
	private Runde runde10 = new Runde(10 ,"Fult hus");
	private Runde runde11 = new Runde(11 ,"Alle ulike");
	private Runde runde12 = new Runde(12 ,"Alle like");
	
	
	public Runde[] getRad() {
		return rad;
	}

	public void setRad(Runde[] rad) {
		this.rad = rad;
	}

	public Rad() {
		rad = new Runde[12];
		rad[0] = runde1;
		rad[1] = runde2;
		rad[2] = runde3;
		rad[3] = runde4;
		rad[4] = runde5;
		rad[5] = runde6;
		rad[6] = runde7;
		rad[7] = runde8;
		rad[8] = runde9;
		rad[9] = runde10;
		rad[10] = runde11;
		rad[11] = runde12;
	}
	
	public int rundeSjekk(int runde, ArrayList<Dyr> terningkast) {
		int resultat = 0;
		Map<Dyr, Integer> antallKart = mapAntall(terningkast);
		if (runde < 7) {
			for (Dyr dyr : terningkast) {
				if (dyr.getId() == runde) {
					resultat++;
				}
			}
		} else if (runde == 7) {
			for (Dyr key : antallKart.keySet()) {
	            int forekomst = antallKart.get(key);
	            if (forekomst >= 3) {
	            	resultat = 3;
	            }
	        }
		} else if (runde == 8) {
			for (Dyr key : antallKart.keySet()) {
	            int forekomst = antallKart.get(key);
	            if (forekomst >= 4) {
	            	resultat = 4;
	            }
	        }
		} else if (runde == 9) {
			boolean par1 = false;
			boolean par2 = false;
			for (Dyr key : antallKart.keySet()) {
	            int forekomst = antallKart.get(key);
	            if (forekomst >= 4) {
	            	resultat = 4;
	            } else if (forekomst >= 2) {
	            	if (par1) {
	            		par2 = true;
	            	} else {
	            		par1 = true;
	            	}
	            }
	        }
			if (par1 && par2) {
				resultat = 4;
			}
			
		} else if (runde == 10) {
			boolean par = false;
			boolean trelike = false;
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if (forekomst == 3) {
					trelike = true;
				} else if (forekomst == 2) {
					par = true;
				}
			}
			if (par && trelike) {
				resultat = 5;
			}
		} else if (runde == 11) {
			boolean alleUlike = true;
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if (forekomst >= 2) {
					alleUlike = false;
				}
			}
			if (alleUlike) {
				resultat = 5;
			}
		} else if (runde == 12) {
			for (Dyr key : antallKart.keySet()) {
				int forekomst = antallKart.get(key);
				if (forekomst == 5) {
					resultat = 10;
				}
			}
		}
		System.out.println("\nDu fikk " + resultat + " poeng denne runden.");
		return resultat;
	}
	
	public Map<Dyr, Integer> mapAntall(ArrayList<Dyr> terningkast){
		Map<Dyr, Integer> map = new HashMap<>();
		for (Dyr key : terningkast) {
            if (map.containsKey(key)) {
                int forekomst = map.get(key);
                forekomst++;
                map.put(key, forekomst);
            } else {
                map.put(key, 1);
            }
        }
		return map;
	}
	
}

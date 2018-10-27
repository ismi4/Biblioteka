import java.util.ArrayList;

public class Racun {

	private int brojRacuna;
	private String imeMusterije;
	private int brojPosudenihKnjiga;
	
	private static ArrayList<Racun> racuni = new ArrayList<Racun>();
	
	public Racun() {
		
	}
	
	public Racun(int brojRacuna, String imeMusterije, int brojPosudenihKnjiga) {
		
		if (provjeraZaKreacijuRacuna(brojRacuna)) {
			
			this.brojRacuna = brojRacuna;
			this.imeMusterije = imeMusterije;
			this.brojPosudenihKnjiga = brojPosudenihKnjiga;
			
			racuni.add(this);
			
			System.out.println("Racun je uspjesno kreiran!");
			
		}
		
		
	}
	
	public static String ispisRacuna(int brojRacuna){
		
		for (int i = 0; i < racuni.size(); i++)
			if (brojRacuna == racuni.get(i).brojRacuna) 
				return "Broj racuna: " + racuni.get(i).brojRacuna + "\nIme musterije: " + racuni.get(i).imeMusterije + "\nBroj posudjenih knjiga: " + racuni.get(i).brojPosudenihKnjiga;
			
		return "Unijeti broj racuna ne postoji.";
		
	}
	
	private boolean provjeraZaKreacijuRacuna (int brojRacuna) {
		
		if (brojRacuna < 0) {
			System.out.println("Unos broja racuna ne moze biti negativan broj. Racun nije uspjesno kreiran!");
			return false;
		}
		
		for (int i = 0; i < racuni.size(); i++)
			if (racuni.get(i).brojRacuna == brojRacuna) {
				System.out.println("Unijeti broj racuna vec postoji. Racun nije uspjesno kreiran!");
				return false;
			}
		
		return true;
		
	}
	
	public static Racun getRacun(int brojRacuna) {
		
		int i = 0;
		
		for (i = 0; i < racuni.size(); i++)
			if (racuni.get(i).brojRacuna == brojRacuna)
				return racuni.get(i);
		
		return null;
	}

	public int getBrojPosudenihKnjiga() {
		return brojPosudenihKnjiga;
	}

	public void setBrojPosudenihKnjiga(int brojPosudenihKnjiga) {
		this.brojPosudenihKnjiga = brojPosudenihKnjiga;
	}
	
	

	
}

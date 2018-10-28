import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Knjiga extends Zapisnik {

	private int brojKnjige;
	private String imeKnjige;
	private boolean statusKnjige;
	
	private static Zapisnik zapisnik = new Zapisnik();
	private static ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
	
	public Knjiga() {
		
	}
	
	public Knjiga(int brojKnjige, String imeKnjige, boolean statusKnjige) {
		
		if (provjeraZaKreacijuKnjige(brojKnjige)) {
			
			this.brojKnjige = brojKnjige;
			this.imeKnjige = imeKnjige;
			this.statusKnjige = statusKnjige;
			
			knjige.add(this);
			
			zapisnik.zapisiKreacijuKnjige(brojKnjige, imeKnjige);
			
			System.out.println("Knjiga je uspjesno kreirana!");
			
		}
		
		
	}

		private boolean provjeraZaKreacijuKnjige (int brojKnjige) {
	
			if (brojKnjige < 0) {
					System.out.println("Unos broja knjige ne moze biti negativan broj. Knjiga nije uspjesno kreirana!");
					return false;
			}
	
			for (int i = 0; i < knjige.size(); i++)
				if (knjige.get(i).brojKnjige == brojKnjige) {
					System.out.println("Unijeti broj knjige vec postoji. Knjiga nije uspjesno kreirana!");
					return false;
			}
	
			return true;
	
		}
	
	
	
	public static void podizanjeKnjige(int brojRacuna, int brojKnjige, Date datumPodizanja) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String datumPodizanjaString = dateFormat.format(datumPodizanja);
		
		if (provjeraZaPodizanjeKnjige(brojRacuna, brojKnjige)) {
			
			Knjiga.getKnjiga(brojKnjige).statusKnjige = true;
			Racun.getRacun(brojRacuna).setBrojPosudenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudenihKnjiga() + 1);
			System.out.println("Knjiga je uspjesno podignuta!");
			
			zapisnik.zapisiPodizanjeKnjige(brojKnjige, Knjiga.getKnjiga(brojKnjige).imeKnjige, brojRacuna, Racun.getRacun(brojRacuna).getImeMusterije(), datumPodizanjaString);
			
		}
			
		
		
	}
	
	private static Knjiga getKnjiga(int brojKnjige) {
		
		int i = 0;
		
		for (i = 0; i < knjige.size(); i++)
			if (knjige.get(i).brojKnjige == brojKnjige)
				return knjige.get(i);
		
		return null;
	}
	
	private static boolean provjeraZaPodizanjeKnjige(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Unijeti racun nije pronadjen. Knjiga nije uspjesno podignuta!");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Trazena knjiga nije pronadjena!");
			return false;
		}
		
		if (trenutniRacun.getBrojPosudenihKnjiga() == 3) {
			System.out.println("Unijeti racun vec ima tri podignute knjige. Knjiga nije uspjesno podignuta!");
			return false;
		}
		
		if (trenutnaKnjiga.statusKnjige) {
			System.out.println("Trazena knjiga je vec podignuta!");
			return false;
		}
		
		return true;
		
		
	}
	
	public static void vracanjeKnjige(int brojRacuna, int brojKnjige, Date datumVracanja) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String datumVracanjaString = dateFormat.format(datumVracanja);
		
		if (provjeraZaVracanjeKnjige(brojRacuna, brojKnjige)) {
			
			Knjiga.getKnjiga(brojKnjige).statusKnjige = false;
			Racun.getRacun(brojRacuna).setBrojPosudenihKnjiga(Racun.getRacun(brojRacuna).getBrojPosudenihKnjiga() - 1);
			System.out.println("Knjiga je uspjesno vracena!");
			
			zapisnik.zapisiVracanjeKnjige(brojKnjige, Knjiga.getKnjiga(brojKnjige).imeKnjige, brojRacuna, Racun.getRacun(brojRacuna).getImeMusterije(), datumVracanjaString);
			
		}
			
		
		
	}
	
	private static boolean provjeraZaVracanjeKnjige(int brojRacuna, int brojKnjige) {
		
		Racun trenutniRacun = Racun.getRacun(brojRacuna);
		
		if (trenutniRacun == null) {
			System.out.println("Unijeti racun nije pronadjen. Knjiga nije uspjesno vracena!");
			return false;
		}
		
		Knjiga trenutnaKnjiga = Knjiga.getKnjiga(brojKnjige);
		
		if (trenutnaKnjiga == null) {
			System.out.println("Trazena knjiga nije pronadjena!");
			return false;
		}
		
		if (!trenutnaKnjiga.statusKnjige) {
			System.out.println("Trazena knjiga nije podignuta!");
			return false;
		}
		
		return true;
		
		
	}
	
	
	
}

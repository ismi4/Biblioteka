import java.util.ArrayList;

public class Zapisnik {
	
	private static ArrayList<String> zapisnik = new ArrayList<String>(); 
	
	protected void zapisiKreacijuRacuna(int brojRacuna, String imeMusterije ) {
		zapisnik.add("Kreacija racuna: " + brojRacuna + "   " + imeMusterije);
	}
	
	protected void zapisiKreacijuKnjige(int brojKnjige, String imeKnjige) {
		zapisnik.add("Kreacija knjige: " + brojKnjige + "   " + imeKnjige);
	}
	
	protected void zapisiPodizanjeKnjige(int brojKnjige, String imeKnjige, int brojRacuna, String imeMusterije, String datumPodizanja) {
		zapisnik.add("Podizanje knjige: " + brojKnjige + imeKnjige + "----- Racun: " + brojRacuna + imeMusterije + " ------ Datum: " + datumPodizanja);
	}
	
	protected void zapisiVracanjeKnjige(int brojKnjige, String imeKnjige, int brojRacuna, String imeMusterije, String datumVracanja) {
		zapisnik.add("Vracanje knjige: " + brojKnjige + imeKnjige + "----- Racun: " + brojRacuna + imeMusterije + " ------ Datum: " + datumVracanja);
	}
	
	public static String ispisiZapisnik() {
		
		String zapisnikString = "";
		
		for (int i = 0; i < zapisnik.size(); i++)
			zapisnikString += zapisnik.get(i) + "\n";
		
		return zapisnikString;
	}

}

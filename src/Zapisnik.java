
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;



public class Zapisnik {


	private static String zapisnikString = "";

	protected void zapisiKreacijuRacuna(int brojRacuna, String imeMusterije ) {
		zapisnikString += "Kreacija racuna: " + brojRacuna + "   " + imeMusterije + "\n";
	}

	protected void zapisiKreacijuKnjige(int brojKnjige, String imeKnjige) {
		zapisnikString += "Kreacija knjige: " + brojKnjige + "   " + imeKnjige + "\n";
	}

	protected void zapisiPodizanjeKnjige(int brojKnjige, String imeKnjige, int brojRacuna, String imeMusterije, String datumPodizanja) {
		zapisnikString += "Podizanje knjige: " + brojKnjige + imeKnjige + "----- Racun: " + brojRacuna + imeMusterije + " ------ Datum: " + datumPodizanja + "\n";
	}

	protected void zapisiVracanjeKnjige(int brojKnjige, String imeKnjige, int brojRacuna, String imeMusterije, String datumVracanja) {
		zapisnikString += "Vracanje knjige: " + brojKnjige + imeKnjige + "----- Racun: " + brojRacuna + imeMusterije + " ------ Datum: " + datumVracanja + "\n";
	}

	public static String ispisiZapisnik() {
		return zapisnikString;
	}

	public static void loading() throws IOException {
		
		try {
		
		File f = new File("zapisnik.txt");

		byte[] bytes = Files.readAllBytes(f.toPath());
		zapisnikString = new String(bytes,"UTF-8");
		
		} catch(Exception e) {
			
		}
		
	}

	public static void save() throws IOException {

		try {
			FileWriter write = new FileWriter("zapisnik.txt");
			write.write(zapisnikString);
			write.close();
		} 
		catch (Exception e) {}
	}


}

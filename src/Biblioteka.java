import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteka {

    private static String zapisnik = "";
    public static ArrayList<Knjiga> listaKnjiga = new ArrayList<Knjiga>();
    public static ArrayList<Racun> listaRacuna = new ArrayList<Racun>();
    private static Scanner input = new Scanner (System.in);
    private static int trenutniBrojRacuna = 0;
    private static int trenutniBrojKnjiga = 0;
    
    public static void main(String[] args) {
	
	odabirAkcije();
	
	
	}
	
    
    
    private static void odabirAkcije () {
	System.out.println("--------------------------------------------------------");
	System.out.println("Odaberite zeljenu akciju: \n1.Kreiranje racuna \n2.Kreiranje knjige \n3.Podizanje knjige \n4.Vracanje knjige \n5.Podaci racuna \n6.Podaci knjige \n7.Ispis zapisnika ");
	
	int odabirAkcije = Integer.parseInt(input.nextLine());
	
	if (odabirAkcije == 1) 
	    kreacijaRacuna();
	else if (odabirAkcije == 2)
	    kreacijaKnjige();
	else if (odabirAkcije == 3)
	    podizanjeKnjige();
	else if (odabirAkcije == 4)
	    vracanjeKnjige();
	else if (odabirAkcije == 5)
	    podaciRacuna();
	else if (odabirAkcije == 6)
	    podaciKnjige();
	else if (odabirAkcije == 7)
	    ispisZapisnika();
	else {
	    System.out.println("Molimo vas da unesete ispravan unos!");
	    odabirAkcije();
	}
	    
}
    
    private static void kreacijaRacuna () {
	
	System.out.println("--------------------------------------------------------");
	System.out.println("KREACIJA RACUNA");
	System.out.println("Ime i prezime: ");
	String imePrezime = input.nextLine();
	
	if (imePrezime.length() != 0) {
	
	if (provjeraUnosaImena(imePrezime) == false) {
	    System.out.println("Unos imena i prezimena nije ispravan. Pokusajte ponovo.");
	    kreacijaRacuna();
	} else {
	
	    
	Racun racun = new Racun (trenutniBrojRacuna, imePrezime, 0);
	listaRacuna.add(racun);
	
	trenutniBrojRacuna++;
	
	System.out.println("Vas racun je kreiran.");
	podaciRacuna();
	
	odabirAkcije();
	}}
    }
    
    private static void kreacijaKnjige () {
	System.out.println("--------------------------------------------------------");
	System.out.println("KREACIJA KNJIGE");
	System.out.println("Ime knjige: ");
	String imeKnjige = input.nextLine();
	
	if (provjeraUnosaImena(imeKnjige) == false) {
	    System.out.println("Unos imena knjige nije ispravan. Pokusajte ponovo.");
	    kreacijaKnjige();
	} else {
	
	    
	Knjiga knjiga = new Knjiga (trenutniBrojKnjiga, imeKnjige, false);
	listaKnjiga.add(knjiga);
	
	trenutniBrojKnjiga++;
	
	System.out.println("Vasa knjiga je kreirana.");
	
	odabirAkcije();
	podaciKnjige();
	}}
	
 
    
    private static void podizanjeKnjige () {
	
	System.out.println("--------------------------------------------------------");
	System.out.println("Vaš broj racuna: ");
	int brojRacuna = Integer.parseInt(input.nextLine());
		if (brojRacuna < 0 || brojRacuna >= trenutniBrojRacuna) {
		    System.out.println("Unos nije validan. Pokusajte ponovo.");
		    podizanjeKnjige();
		}
		else if (listaRacuna.get(brojRacuna).brojPosudenihKnjiga >= 3){
		    	System.out.println("Vec imate tri izdate knjige. Molim vas da podignete sljedecu kad vratite one koje su kod vas.");
		    	    odabirAkcije();
		    	}
		else {
		    System.out.println("Broj knjige koju podizete: ");
		    int brojKnjige = Integer.parseInt(input.nextLine());
		     
		    	if (brojKnjige < 0 || brojKnjige >= trenutniBrojKnjiga) {
		    	    System.out.println("Unos nije validan. Pokusajte ponovo.");
		    	    podizanjeKnjige();
		    	}
		    	else if (listaKnjiga.get(brojKnjige).status == true) {
		    	System.out.println("Ta knjiga je vec izdata. Odaberite drugu knjigu.");
		    	    podizanjeKnjige();
		    	}
		    	else {
		    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.now();
			String date = (dtf.format(localDate)); 
			
			listaRacuna.get(brojRacuna).brojPosudenihKnjiga++;
			listaKnjiga.get(brojKnjige).status = true;
			
			
		    	    
		    	    zapisnik += "Podignuto: " + listaRacuna.get(brojRacuna).ime + "  |  " + listaKnjiga.get(brojKnjige).imeKnjige + "  |  " + date +"\n";
		    	 
		    	    System.out.println("Knjiga je uspjesno podignuta.");
		    	    odabirAkcije();
		    	}
		}
	
	
    }
    
    private static void vracanjeKnjige () {
	System.out.println("--------------------------------------------------------");
	System.out.println("Vaš broj racuna: ");
	int brojRacuna = Integer.parseInt(input.nextLine());
		if (brojRacuna < 0 || brojRacuna >= trenutniBrojRacuna) {
		    System.out.println("Unos nije validan. Pokusajte ponovo.");
		    vracanjeKnjige();
		}
		else if (listaRacuna.get(brojRacuna).brojPosudenihKnjiga <= 0){
		    	System.out.println("Nemate podignutih knjiga.");
		    	    odabirAkcije();
		    	}
		else {
		    System.out.println("Broj knjige koju vracate: ");
		    int brojKnjige = Integer.parseInt(input.nextLine());
		     
		    	if (brojKnjige < 0 || brojKnjige >= trenutniBrojKnjiga) {
		    	    System.out.println("Unos nije validan. Pokusajte ponovo.");
		    	    podizanjeKnjige();
		    	}
		    	else if (listaKnjiga.get(brojKnjige).status == false) {
		    	System.out.println("Ta knjiga nije izdata. Odaberite drugu knjigu.");
		    	    podizanjeKnjige();
		    	}
		    	else {
		    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate localDate = LocalDate.now();
			String date = (dtf.format(localDate)); 
			
			listaRacuna.get(brojRacuna).brojPosudenihKnjiga--;
			listaKnjiga.get(brojKnjige).status = false;
			
			
		    	    
		    	    zapisnik += "Vraceno: " + listaRacuna.get(brojRacuna).ime + "  |  " + listaKnjiga.get(brojKnjige).imeKnjige + "  |  " + date + "\n";
		    	    
		    	    System.out.println("Knjiga je uspjesno vracena.");
		    	    odabirAkcije();
		    	}
		}
	
	
	
    }
    
    private static void podaciRacuna () {
	System.out.println("--------------------------------------------------------");
	System.out.println("Vas broj racuna: ");
	int brojRacuna = Integer.parseInt(input.nextLine());
	
	if (brojRacuna < 0 || brojRacuna >= trenutniBrojRacuna) {
	    System.out.println("Unos nije ispravan. Pokusajte ponovo.");
	    podaciRacuna();
	}else {
	System.out.println("Ime i prezime: " + listaRacuna.get(brojRacuna).ime);
	System.out.println("Broj racuna: " + brojRacuna);
	System.out.println("Broj podignutih knjiga: " + listaRacuna.get(brojRacuna).brojPosudenihKnjiga);
	odabirAkcije();
    }
	}
    
    private static void podaciKnjige () {
	System.out.println("--------------------------------------------------------");
	System.out.println("Broj knjige: ");
	int brojKnjige = Integer.parseInt(input.nextLine());
	
	if (brojKnjige < 0 || brojKnjige >= trenutniBrojKnjiga) {
	    System.out.println("Unos nije ispravan. Pokusajte ponovo.");
	    podaciKnjige();
	}else {
	System.out.println("Naziv knjige: " + listaKnjiga.get(brojKnjige).imeKnjige);
	System.out.println("Broj knjige: " + brojKnjige);
	System.out.println("Status knjige: " + listaKnjiga.get(brojKnjige).status);
	odabirAkcije();
    }
    }
    
    private static void ispisZapisnika () {
	System.out.println(zapisnik);
	odabirAkcije();
    }
    
    private static boolean provjeraUnosaImena (String imePrezime) {
	
	for (int i = 0; i < imePrezime.length(); i++)
	    if (Character.isLetter(imePrezime.charAt(i)) || Character.isWhitespace(imePrezime.charAt(i)))
		continue;
	    else
		return false;
	
	return true;
    }
}

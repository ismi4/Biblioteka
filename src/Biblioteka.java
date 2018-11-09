
import java.io.IOException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Biblioteka {
	
	private static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) throws IOException {

		Knjiga.loading();
		Racun.loading();
		Zapisnik.loading();
		glavniMenu();
		
		
	}
	
	public static void glavniMenu() throws IOException {
		
		System.out.println("--------------------------------------------------------");
		System.out.println("Odaberite zeljenu akciju: \n1.Kreiranje racuna \n2.Kreiranje knjige \n3.Podizanje knjige \n4.Vracanje knjige \n5.Ispis detalja racuna \n6.Ispis zapisnika \n7.Zatvaranje aplikacije ");
		System.out.println("--------------------------------------------------------");
		
		
		int inputValue = 0;
		
		while (true)
		try {
			inputValue = input.nextInt();
			
			if (inputValue != 1 && inputValue != 2 && inputValue != 3 && inputValue != 4 && inputValue != 5 && inputValue != 6 && inputValue != 7) 
				throw new InputMismatchException();
				
				break;
				
		} catch(Exception e) {
			input.nextLine();
			System.out.println("Molimo vas da unesete valjan unos opcije! ");
			continue;
		}
		
		switch (inputValue) {
		case 1: kreiranjeRacuna(); break;
		case 2: kreiranjeKnjige(); break;
		case 3: podizanjeKnjige(); break;
		case 4: vracanjeKnjige(); break;
		case 5: ispisRacuna(); break;
		case 6: ispisZapisnika(); break;
		case 7: Knjiga.save();Racun.save(); Zapisnik.save(); System.exit(0);
		}
		
		
	}
	
	public static void kreiranjeRacuna() throws IOException {
	
		int brojRacuna = 0;
		int brojPodignutihKnjiga = 0;
		
		System.out.println("Unesite broj racuna: ");
		brojRacuna = unosIntegera();

		input.nextLine();
		System.out.println("Unesite ime musterije: ");
		String imeMusterije = input.nextLine();
		
		new Racun(brojRacuna, imeMusterije, brojPodignutihKnjiga);
		
		glavniMenu();
		
	}

	public static void kreiranjeKnjige() throws IOException {
		
        System.out.println("Unesite broj knjige: ");
		int brojKnjige = unosIntegera();
		
		input.nextLine();
		System.out.println("Unesite ime knjige: ");
		String imeKnjige = input.nextLine();
		
		new Knjiga(brojKnjige, imeKnjige, false);
		
		glavniMenu();
	}
	
	public static void podizanjeKnjige() throws IOException {
		
		System.out.println("Unesite vas broj racuna: ");
		int brojRacuna = unosIntegera();
		
		System.out.println("Unesite broj knjige: ");
		int brojKnjige = unosIntegera();
		
		Knjiga.podizanjeKnjige(brojRacuna, brojKnjige, new Date());
		
		glavniMenu();
		
	}
	
	public static void vracanjeKnjige() throws IOException {
		
		int brojRacuna = 0;
		int brojKnjige = 0;
		
		System.out.println("Unesite vas broj racuna: ");
		brojRacuna = unosIntegera();
		
		System.out.println("Unesite broj knjige: ");
		brojKnjige = unosIntegera();
		
		Knjiga.vracanjeKnjige(brojRacuna, brojKnjige, new Date());
		
		glavniMenu();
		
	}
	
	public static void ispisRacuna() throws IOException {
		
		int brojRacuna = 0;
		
		System.out.println("Unesite broj racuna: ");
		brojRacuna = unosIntegera();
		
		System.out.println(Racun.ispisRacuna(brojRacuna));
		
		glavniMenu();
	}
	
	public static void ispisZapisnika() throws IOException {
	
		System.out.println(Zapisnik.ispisiZapisnik());
		
		glavniMenu();
		
	}
	

	
	public static int unosIntegera () {
		
		int uneseniBroj = 0;
		
		while (true)
		try {
			uneseniBroj = input.nextInt();
			break;
		} catch (Exception e) {
			System.out.println("Unesite ispravan unos!");
			input.nextLine();
			continue;
		}
		
		return uneseniBroj;
		
	}
	
}

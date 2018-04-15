import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Gra{
	
	private int N;
	private int losowaLiczba, podanaLiczba = 0;
	Scanner wprowadzLiczbe = new Scanner(System.in);
	
	public Gra(int _N){
		this.N = _N;
	}


private void generujLiczbe(){
	Random generator = new Random();	
	losowaLiczba = generator.nextInt(N);
}


private void pobierzLiczbeOdUzytkownikaISprawdzPoprawnosc(){
	boolean czyWprowadzonyArgumentJestPoprawny;
	System.out.println("Wprowadz liczbe: ");
	do{
		czyWprowadzonyArgumentJestPoprawny = true;
		try{
			podanaLiczba = wprowadzLiczbe.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("Podany argument nie jest liczba!\nWprowadz go jeszcze raz!");
			wprowadzLiczbe.nextLine();
			czyWprowadzonyArgumentJestPoprawny = false;
			}
	}while(!czyWprowadzonyArgumentJestPoprawny);
}


private boolean czyGraczKontynuujeGre(){
	String wybor;
	Scanner wyborGracza = new Scanner(System.in);
	boolean czyWyborJestPoprawny, czyKonczeGre = false;
	
	System.out.println("Czy chcesz zagrac jeszcze raz? [T]/[N]");
	do{
		czyWyborJestPoprawny = true;
		wybor = wyborGracza.nextLine();
		if(wybor.equals("T") || wybor.equals("t"))
			czyKonczeGre = true;		
		else if(wybor.equals("N") || wybor.equals("n"))
			czyKonczeGre = false;
		else{
			System.out.println("Podales zla wartosć!\nWprowadz ja jeszcze raz: ");
			czyWyborJestPoprawny = false;
		}
	}while(!czyWyborJestPoprawny);

	return czyKonczeGre;
}


public void startGry(){
	
	boolean czyJestIntegerem = true, czyGraJeszczeRaz = false, czyLiczbaJestPoprawna = true;
	int liczbaProb = 0;
	
	do{
		generujLiczbe();
		do{
			pobierzLiczbeOdUzytkownikaISprawdzPoprawnosc();
		
			if(podanaLiczba < losowaLiczba){
				System.out.println("\nZa mala!\n");
				liczbaProb++;
			}
			else if(podanaLiczba > losowaLiczba){
				System.out.println("\nZa duza!\n");
				liczbaProb++;
			}
			else{
				System.out.println("Akurat!\nKoniec gry!");
				System.out.println("Liczba prob: " + (liczbaProb + 1));
			} 
				
			
		}while(podanaLiczba != losowaLiczba);
		System.out.println("Gratuluje wygranej!");
		liczbaProb = 0;
	
	}while(czyGraczKontynuujeGre());

	System.out.println("Dziekuje za gre!");
}
}
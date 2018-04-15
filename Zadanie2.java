
class Zadanie2{
	public static void main(String[] args){
		int N = 0;
		
		System.out.println("Witam w grze polegajacej na zgadnieciu wylosowanego numeru.\nZycze milej zabawy!");
		
		if(args.length < 1){
			System.out.println("Nie wprowadziles zadnego argumentu!\nUruchom gre raz jeszcze z prawidlowo podanym argumentem bedacy liczba naturalna wieksza od 0\n");
			System.exit(0);
		}else if(args.length > 1){
			System.out.println("Wprowadziles za duzo argumentow!\nUruchom gre raz jeszcze z prawidlowo podanym argumentem bedacy liczba naturalna wieksza od 0\n");
			System.exit(0);
		}else{
			try{
				N = Integer.parseInt(args[0]);
			}catch(NumberFormatException error){
				System.out.println("Wprowadzona wartosc nie jest liczba naturalna!\nUruchom gre raz jeszcze z prawidlowo podanym argumentem bedacy liczba naturalna wieksza od 0\n");
				System.exit(0);
			}
			if(N < 1){
				System.out.println("Wprowadzona licza jest za mala! Musi wynosic conajmniej 1.\nUruchom gre raz jeszcze z prawidlowo podanym argumentem bedacy liczba naturalna wieksza od 0\n");
				System.exit(0);
			}
		}
		
		Gra Game = new Gra(N);
		Game.startGry();
	}
}
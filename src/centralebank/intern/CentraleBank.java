package centralebank.intern;

import java.util.Scanner;

public class CentraleBank {

	public void openen(){
		boolean goOn = true;
		while(goOn){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Centrale Bank voer iets aan: ");
			String gogo = scanner.nextLine();
			System.out.println(gogo);
			if(gogo.equals("exit")){
				System.out.println("De bank is gesloten.");
				goOn = false;
			}
		}
	}
}

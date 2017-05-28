package bank.model;

import java.util.List;
import java.util.Scanner;

import centralebank.interactief.IIntermediairCentraleBank;

public class Bank {
	private String IBAN;
	private String naam;
	private String landcode;
	
	private IIntermediairCentraleBank iicb;
	private List<Sessie> sessies;
	
	
	
	
	public void openen(){
		Scanner scanner = new Scanner(System.in);
		boolean goOn = true;
		while(goOn){
			System.out.println("Voer uw bestelling in. ");
			String str = scanner.nextLine();
			System.out.println("input is: " + str);
			if(str.equals("exit")){
				goOn = false;
			}
		}
		System.out.println("De bank is gesloten. ");
	}
}

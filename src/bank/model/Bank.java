package bank.model;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

import bank.interactief.client.ILoginBank;
import bank.interactief.client.LoginCentrale;
import centralebank.interactief.IIntermediairCentraleBank;

public class Bank {
	private String IBAN;
	private String naam;
	private String landcode;
	
	private IIntermediairCentraleBank iicb;
	private List<Sessie> sessies;
	
	ILoginBank iLoginBank;
	
	public Bank(){
		try {
			iLoginBank = new LoginCentrale();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	void loginCentraleRegistreren() throws InterruptedException{
		Registry registry = null;
		try {
		      registry = LocateRegistry.createRegistry(1099);
		} catch (RemoteException ex) {
			System.out.println("Registry-creation is not working: " + ex.getMessage());
		} 
		try {
//			IEffectenBeurs effBeurs = new EffectenBeurs();
			registry.rebind("jojo", iLoginBank);
		} catch (RemoteException exc) { 
			System.out.println("effBeurs is not bound.");
		}
	}
	public void openen(){
		try{
		loginCentraleRegistreren();
		}catch(Exception e){}
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

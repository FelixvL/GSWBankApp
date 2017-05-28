package bank.model;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import bank.interactief.client.ILoginBank;
import bank.interactief.client.LoginCentrale;
import bankclient.interactief.ILoginClient;

public class Bank {
//	private String IBAN;
//	private String naam;
//	private String landcode;
	
//	private IIntermediairCentraleBank iicb;
//	private List<Sessie> sessies;
	
	private ILoginBank iLoginBank;
	private ILoginClient iLoginClient;
	public void actie() throws Exception{
		System.out.println("actie in bank");
	     Registry registry = null;
	        try {
	        	registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(),1098);
	        } catch (RemoteException ex) { 
	        	System.out.println("Locate Registry mislukt");
	        	ex.printStackTrace();
	        }
	        try {
	        	ILoginClient loginClient = (ILoginClient)registry.lookup("loginclient");
	        	iLoginClient = loginClient;
	        } catch (RemoteException exc) {
	        	System.out.println("Verbind met Bank mislukt in ClientGUIController: " + exc.getMessage());
	        }
	        try{
	        	iLoginClient.proberen();
	        }catch(RemoteException e){
	        	System.out.println("aanroep methode bij bank mislukt in ClientGUIController.");
	        }
		
	}
	
	public Bank(){
		try {
			iLoginBank = new LoginCentrale(this);
		} catch (RemoteException e) {
			System.out.println("Instantiatie van LoginCentrale mislukt vanuit Bank");
			e.printStackTrace();
		}
	}
	
	void loginCentraleRegistreren() throws InterruptedException{
		Registry registry = null;
		try {
		      registry = LocateRegistry.createRegistry(1099);
		} catch (RemoteException ex) {
			System.out.println("Registry-creation is niet gelukt vanuit bank: " + ex.getMessage());
		} 
		try {
			registry.rebind("loginbank", iLoginBank);
		} catch (RemoteException exc) { 
			System.out.println("LoginBank is not bound.");
			exc.printStackTrace();
		}
	}
	public void openen(){
		try{
			loginCentraleRegistreren();
		}catch(InterruptedException e){
			System.out.println("Aanroep van het registreren van de bank mislukt");
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(System.in);
		boolean goOn = true;
		while(goOn){
			System.out.println("Voer uw bestelling in. ");
			String str = scanner.nextLine();
			System.out.println("input is: " + str);
			if(str.equals("exit")){
				goOn = false;
			}
			if(str.equals("gomfr")){
				try{
				iLoginClient.nogmaals();
				}catch(Exception e){
					
				}
			}
		}
		System.out.println("De bank is gesloten. ");
		scanner.close();
	}
}

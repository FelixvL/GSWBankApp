package bankclient.gui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import bank.interactief.client.ILoginBank;
import bankclient.GUIClient;
import bankclient.interactief.ILoginClient;
import bankclient.interactief.LoginClient;

public class ClientGUIController {
	GUIClient guiClient;
	ILoginClient iLoginClient;
	ILoginBank bankCentrale;
	
	public ClientGUIController(GUIClient guiClient){
		this.guiClient = guiClient;
		try{
			iLoginClient = new LoginClient(this);
			registreerLoginClient();
		}catch(Exception e){
			
		}
		
	}
	void registreerLoginClient()throws InterruptedException{
		Registry registry = null;
		try {
		      registry = LocateRegistry.createRegistry(1098);
		} catch (RemoteException ex) {
			System.out.println("Registry-creation is niet gelukt vanuit ClientGUI: " + ex.getMessage());
		} 
		try {
			registry.rebind("loginclient", iLoginClient);
		} catch (RemoteException exc) { 
			System.out.println("LoginClient is not bound.");
			exc.printStackTrace();
		}
	}
	
	public boolean verbindMetBank(String username, String password) throws UnknownHostException, NotBoundException{
        Registry registry = null;
        try {
        	registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(),1099);
        } catch (RemoteException ex) { 
        	System.out.println("Locate Registry mislukt");
        	ex.printStackTrace();
        	return false;
        }
        try {
        	ILoginBank loginBank = (ILoginBank)registry.lookup("loginbank");
        	bankCentrale = loginBank;
        } catch (RemoteException exc) {
        	System.out.println("Verbind met Bank mislukt in ClientGUIController: " + exc.getMessage());
        	return false;
        }
        try{
        	bankCentrale.testMethodeBijBank();
        }catch(RemoteException e){
        	System.out.println("aanroep methode bij bank mislukt in ClientGUIController.");
        	return false;
        }
		return true;
	}
	public void testFunctie(){
		System.out.println("In testFunctie");
		guiClient.setTeksten();
	}
}

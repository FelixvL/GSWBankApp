package bankclient.gui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import bank.interactief.client.ILoginBank;
import bankclient.interactief.ILoginClient;
import bankclient.interactief.LoginClient;

public class ClientGUIController {
	GUIClient guiClient;
	ILoginClient iLoginClient;
	ILoginBank bankCentrale;
	
	ClientGUIController(GUIClient guiClient){
		this.guiClient = guiClient;
		iLoginClient = new LoginClient();
	}
	boolean verbindMetBank(String username, String password) throws UnknownHostException, NotBoundException{
        Registry registry = null;
try {
	registry = LocateRegistry.getRegistry(InetAddress.getLocalHost().getHostAddress(),1099);
} catch (RemoteException ex) { 
	System.out.println("Locale Registry mislukt");
}
try {
//	"jojo", iLoginBank
	ILoginBank bankding = (ILoginBank)registry.lookup("jojo");
	bankCentrale = bankding;
//	return effectenBeurs.beursWaarde();
} catch (RemoteException exc) {
	System.out.println("mislukt" + exc.getMessage());
}
//        return null;
try{
	bankCentrale.nouEn();
}catch(Exception e){}
		return true;
	}
}

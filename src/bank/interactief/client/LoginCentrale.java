package bank.interactief.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginCentrale extends UnicastRemoteObject implements ILoginBank {
	public LoginCentrale() throws RemoteException{
		super();
	}
	@Override
	public void nouEn(){
		System.out.println("nouEn Vanuit LoginCentrale");
	}
}

package bank.interactief.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bank.model.Bank;

public class LoginCentrale extends UnicastRemoteObject implements ILoginBank {
	/**
	 * 
	 */
	private static final long serialVersionUID = -791419465315629285L;
	private Bank bank;
	public LoginCentrale(Bank bank) throws RemoteException{
		super();
		this.bank = bank;
	}
	@Override
	public void testMethodeBijBank(){
		System.out.println("testMethode Vanuit LoginCentrale");
		try{
		bank.actie();
		}catch(Exception e){}
	}
}

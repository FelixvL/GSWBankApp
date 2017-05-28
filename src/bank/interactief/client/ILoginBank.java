package bank.interactief.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginBank extends Remote {
	void testMethodeBijBank() throws RemoteException;
}

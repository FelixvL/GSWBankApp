package bankclient.interactief;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginClient extends Remote{
	void proberen() throws RemoteException;
	void nogmaals() throws RemoteException;

}

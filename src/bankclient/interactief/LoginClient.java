package bankclient.interactief;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import bankclient.gui.ClientGUIController;

public class LoginClient extends UnicastRemoteObject implements ILoginClient {
	private ClientGUIController clientGUIController;
	public LoginClient(ClientGUIController clientGUIController) throws RemoteException {
		super();
		this.clientGUIController = clientGUIController;
	}
	@Override
	public void proberen() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("proberen in LoginClient");
		
	}
	@Override
	public void nogmaals() throws RemoteException{
		clientGUIController.testFunctie();
	}

}

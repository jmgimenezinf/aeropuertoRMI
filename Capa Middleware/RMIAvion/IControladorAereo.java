package RMIAvion;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IControladorAereo extends Remote{
	public void solicitarPista(String nombreAvion,Integer puerto) throws RemoteException;
}

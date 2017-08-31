package RMIControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISincronizable extends Remote{
	
	public void sincronizar() throws RemoteException ;
}

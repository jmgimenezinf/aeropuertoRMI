package RMIControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAvion extends Remote {
	public void pistaAsignada(Integer nroPista)throws RemoteException;
	public void noHayPista(Integer nroTurno)throws RemoteException;

}

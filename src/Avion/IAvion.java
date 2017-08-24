package Avion;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAvion extends Remote,IAvionSerializable {
	public void pistaAsignada(Integer nroPista)throws RemoteException;
	public void noHayPista(Integer nroTurno)throws RemoteException;
	public String getNombre();

}

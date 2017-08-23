package Avion;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAvion extends Serializable {
	public void pistaAsignada(Integer nroPista)throws RemoteException;
	public void noHayPista(Integer nroTurno)throws RemoteException;
	public String getNombre();

}

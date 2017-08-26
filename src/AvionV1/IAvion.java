package AvionV1;

import java.rmi.RemoteException;

public interface IAvion {
	public void pistaAsignada(Integer nroPista)throws RemoteException;
	public void noHayPista(Integer nroTurno)throws RemoteException;
	public String getNombre();

}

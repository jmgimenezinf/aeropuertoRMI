package AvionV1;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface IAvionSerializable extends Serializable{
	public String getNombre();
	public void setNombre(String nombre);
	public void pistaAsignada(Integer nroPista)throws RemoteException;
	public void noHayPista(Integer nroTurno)throws RemoteException;
}

package ControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Avion.Avion;
import Avion.IAvion;

public interface IControladorAereo extends Remote{

	public void solicitarPista(IAvion avion) throws RemoteException;
	public void mensajeDePrueba() throws RemoteException;

}

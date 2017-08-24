package ControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import Avion.IAvion;
import Avion.IAvionSerializable;

public interface IControladorAereo extends Remote{

	public void solicitarPista(IAvionSerializable avion) throws RemoteException;
	public void mensajeDePrueba(IAvionSerializable avion) throws RemoteException;

}

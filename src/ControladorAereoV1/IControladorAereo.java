package ControladorAereoV1;

import java.rmi.Remote;
import java.rmi.RemoteException;

import AvionV1.IAvion;
import AvionV1.IAvionSerializable;

public interface IControladorAereo extends Remote{

	public void solicitarPista(IAvionSerializable avion) throws RemoteException;
	public void mensajeDePrueba(IAvionSerializable avion) throws RemoteException;

}

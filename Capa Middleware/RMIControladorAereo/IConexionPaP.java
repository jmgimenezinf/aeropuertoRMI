package RMIControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import Middleware.ITiempoDerivaSerializable;

public interface IConexionPaP extends Remote {
	public Integer solicitarPuerto() throws RemoteException ;
	public ITiempoDerivaSerializable sync(String fecha) throws RemoteException;
	public boolean conectarPaP(String idServidor,String ip,Integer puerto)throws RemoteException;
	
}

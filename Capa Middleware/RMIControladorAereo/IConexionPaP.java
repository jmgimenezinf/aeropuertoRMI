package RMIControladorAereo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IConexionPaP extends Remote {
	public Integer solicitarPuerto() throws RemoteException ;
	public boolean conectarPaP(String idServidor,Integer puerto)throws RemoteException;
	
}
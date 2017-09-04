package RMI;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public  class Servidor extends UnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer nroPuerto;
	protected String IP;
	protected Registry registro;

	protected Servidor(Integer numeroPuertoRemoto,String nombreServidor,String ip) throws RemoteException {

			IP = ip;
		System.out.println("Puerto N°"+numeroPuertoRemoto);
		nroPuerto = numeroPuertoRemoto;
		try {
			registro = LocateRegistry.createRegistry(nroPuerto); // crea el registro
			registro.rebind(nombreServidor, this); // registra el servicio
		} catch (AccessException e) {
			System.out.println("Error al registrar el servicio - AccessException");
		} catch (RemoteException e) {
			System.out.println("Error al registrar el servicio - RemoteException");
		}
		System.out.println("Servidor: "+nombreServidor +" IP:"+ IP);

	}

}

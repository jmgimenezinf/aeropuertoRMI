package RMIV1;

import java.net.InetAddress;
import java.net.UnknownHostException;
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

	protected Servidor(Integer numeroPuertoRemoto) throws RemoteException {

		try {
			IP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			System.out.println("No se encontro el servidor");
		}
		System.out.println("Puerto N°"+numeroPuertoRemoto);
		nroPuerto = numeroPuertoRemoto;
		try {
			registro = LocateRegistry.createRegistry(nroPuerto); // crea el registro
			registro.rebind("rmiServidor", this); // registra el servicio
		} catch (AccessException e) {
			System.out.println("Error al registrar el servicio - AccessException");
		} catch (RemoteException e) {
			System.out.println("Error al registrar el servicio - RemoteException");
		}
		System.out.println("Servidor: " + IP);

	}

}

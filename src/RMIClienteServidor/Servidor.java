package RMIClienteServidor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor extends UnicastRemoteObject implements InterfazReceptorMensajes {

	Integer nroPuerto;
	String IP;
	Registry registro;
	
	protected Servidor(Integer numeroPuertoRemoto) throws RemoteException {
		
		try {
			IP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			System.out.println("No se encontr� el servidor");
		}
		
		nroPuerto = numeroPuertoRemoto;
		try {
			registro = LocateRegistry.createRegistry(nroPuerto); //crea el registro
			registro.rebind("rmiServidor", this); //registra el servicio
		} catch (AccessException e) {
			System.out.println("Error al registrar el servicio - AccessException");
		} catch (RemoteException e) {
			System.out.println("Error al registrar el servicio - RemoteException");
		} 
		System.out.println("Servidor: "+IP);

	}
	
	
	@Override
	public String recibirMensaje(String texto) throws RemoteException {
		System.out.println("Se ha recibido 1 mje: "+texto);
		return texto;
		
	}

	@Override
	public Integer sumar(Integer uno, Integer dos) throws RemoteException {
		Integer resultado = uno + dos;
		System.out.println("Resultado de la suma: "+ resultado);
		return resultado;
	}

}

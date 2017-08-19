package RMIClienteServidor;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazReceptorMensajes extends Remote {
	//Este es el metodo que implementara el servidor
	String recibirMensaje(String texto) throws RemoteException;
	Integer sumar(Integer uno, Integer dos) throws RemoteException;
}

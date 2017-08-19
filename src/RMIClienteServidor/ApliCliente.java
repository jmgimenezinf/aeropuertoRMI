package RMIClienteServidor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ApliCliente {

	public static void main(String[] args) throws RemoteException, NotBoundException {       
		ClienteAvion cliente1 = new ClienteAvion("169.254.69.81",7556);
	//cliente1.enviarMensaje("Hola!");
	//	cliente1.enviarSuma(5,7);	
	}
}

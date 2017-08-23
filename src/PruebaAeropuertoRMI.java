import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.Avion;
import RMIAvionControladorAereo.ClienteAvion;
import RMIAvionControladorAereo.ServidorControladorAereo;

public class PruebaAeropuertoRMI {

	public static void main(String[] args) {
		try {
			ServidorControladorAereo servidorControladorAereo = new ServidorControladorAereo(7556);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Remote excepcion");
		}
		
		ClienteAvion clienteAvion=null;
		try {
			clienteAvion= new ClienteAvion("127.0.1.1",7556);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Avion avionReal = new Avion("1",clienteAvion);
		avionReal.run();
	}

}

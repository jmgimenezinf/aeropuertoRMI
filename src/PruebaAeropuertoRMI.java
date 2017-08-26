import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import AvionV1.Avion;
import AvionV1.AvionSerializable;
import AvionV1.IAvion;
import AvionV1.IAvionSerializable;
import RMIAvionControladorAereoV1.ClienteAvion;
import RMIAvionControladorAereoV1.ServidorControladorAereo;

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

		IAvionSerializable avionPrueba = new AvionSerializable();
		avionPrueba.setNombre("7756");
			try {
				clienteAvion.mensajeDePrueba(avionPrueba);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}

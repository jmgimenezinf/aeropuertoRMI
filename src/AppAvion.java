import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.AvionApli;
import RMIAvion.ClienteAvion;
import source.Configuracion;

public class AppAvion {

	public static void main(String[] args) {
		ClienteAvion cliente=null;
		try {
			cliente = new ClienteAvion(Configuracion.ipServidor,7000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AvionApli avion = new AvionApli("Avion77",cliente);
		avion.solicitarPista();
	}

}



import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.AvionApli;
import Avion.AvionLocal;
import ControladorAereo.ControladorAereo;
import Middleware.Middleware;
import RMIAvion.ClienteAvion;

public class Main {

	public static void main(String[] args) {
		ControladorAereo controladorAereo = new ControladorAereo();
		controladorAereo.start();
		Middleware middleware = new Middleware(controladorAereo);
		ClienteAvion clienteAvion = null;
		try {
			clienteAvion = new ClienteAvion("127.0.1.1",7000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=1 ; i<=5;i++){
			AvionLocal avion = new AvionLocal(Integer.toString(i));
			controladorAereo.solicitarPista(avion);
		}
		AvionApli appAvion = new AvionApli("Avion Remoto 1", clienteAvion);
		appAvion.solicitarPista();
		AvionApli appAvion2 = new AvionApli("Avion Remoto 2", clienteAvion);
		appAvion2.solicitarPista();

	}

}

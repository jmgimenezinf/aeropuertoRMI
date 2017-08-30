package RMIControladorAereo;

import java.rmi.RemoteException;

import Avion.Avion;
import Avion.AvionRemoto;
import Middleware.Middleware;
import RMIAvion.IControladorAereo;
import source.AvionCreator;

public class SingletonGestorSolicitudes {
	private static SingletonGestorSolicitudes instancia=null;

	public static SingletonGestorSolicitudes getInstancia() {
		if (instancia == null) {
			instancia = new SingletonGestorSolicitudes();
		}
		return instancia;
	}


	public void solicitarPista(String nombreAvion, Integer puerto) throws RemoteException {
		ClienteControladorAereo cltCtrlAereo;
		cltCtrlAereo = SingletonRegistroConexiones.getInstancia().getPuertoCliente().get(puerto);
		AvionRemoto avionRemoto = AvionCreator.crearAvionRemoto(nombreAvion,cltCtrlAereo);
		Middleware.getAppControladorAereo().solicitarPista(avionRemoto);
		
	}


	
}

package Middleware;

import java.rmi.RemoteException;

import org.joda.time.DateTime;

import Avion.AvionRemoto;
import Consultas.ConsultasSQL;
import RMIControladorAereo.ClienteControladorAereo;
import source.AvionCreator;

public class SingletonGestorSolicitudes {
	private static SingletonGestorSolicitudes instancia=null;

	public static SingletonGestorSolicitudes getInstancia() {
		if (instancia == null) {
			instancia = new SingletonGestorSolicitudes();
		}
		return instancia;
	}


	public void solicitarPista(String nombreAvion, Integer puerto, String horaSolicitudPista) throws RemoteException {
		ClienteControladorAereo cltCtrlAereo;
		cltCtrlAereo = SingletonRegistroConexiones.getInstancia().getPuertoCliente().get(puerto);
		DateTime dateTime = new DateTime(SingletonNTP.getInstancia().stringToDate(horaSolicitudPista));
		AvionRemoto avionRemoto = AvionCreator.crearAvionRemoto(nombreAvion,cltCtrlAereo,dateTime);
		ConsultasSQL.getInstancia().createAvion(avionRemoto,puerto,horaSolicitudPista);
		Middleware.getAppControladorAereo().solicitarPista(avionRemoto);
		
	}


	
}

package RMIControladorAereo;

import java.rmi.RemoteException;

import ControladorAereo.ControladorAereo;
import Middleware.SingletonGestorSolicitudes;
import Middleware.SingletonRegistroConexiones;
import RMI.Servidor;
import RMIAvion.IControladorAereo;

public class ServidorControladorAereo extends Servidor implements IControladorAereo, IConexionPaP {

	private static final long serialVersionUID = 1L;
	private ControladorAereo appControladorAereo;

	public ServidorControladorAereo(Integer numeroPuertoRemoto, String nombreServidor, ControladorAereo app)
			throws RemoteException {
		super(numeroPuertoRemoto, nombreServidor);
		this.setAppControladorAereo(app);
	}

	@Override
	public void solicitarPista(String nombreAvion,Integer puerto) throws RemoteException {
		SingletonGestorSolicitudes.getInstancia().solicitarPista(nombreAvion, puerto);
	}

	@Override
	public Integer solicitarPuerto(){
		return SingletonRegistroConexiones.getInstancia().solicitarPuerto();
	}

	@Override
	public boolean conectarPaP(String idServidor, Integer puerto) {
		return SingletonRegistroConexiones.getInstancia().conectarPaP(idServidor, puerto);
	}

	public ControladorAereo getAppControladorAereo() {
		return appControladorAereo;
	}

	public void setAppControladorAereo(ControladorAereo appControladorAereo) {
		this.appControladorAereo = appControladorAereo;
	}

}

package RMIControladorAereo;

import java.rmi.RemoteException;

import ControladorAereo.ControladorAereo;
import Middleware.ITiempoDerivaSerializable;
import Middleware.SingletonGestorSolicitudes;
import Middleware.SingletonRegistroConexiones;
import RMI.Servidor;
import RMIAvion.IControladorAereo;

public class ServidorControladorAereo extends Servidor implements IControladorAereo, IConexionPaP {

	private static final long serialVersionUID = 1L;
	private ControladorAereo appControladorAereo;

	public ServidorControladorAereo(String ip,Integer numeroPuertoRemoto, String nombreServidor, ControladorAereo app)
			throws RemoteException {
		super(numeroPuertoRemoto, nombreServidor,ip);
		this.setAppControladorAereo(app);
	}

	@Override
	public void solicitarPista(String nombreAvion,Integer puerto,String horaSolicitudPista) throws RemoteException {
		SingletonGestorSolicitudes.getInstancia().solicitarPista(nombreAvion, puerto,horaSolicitudPista);
	}

	@Override
	public Integer solicitarPuerto(){
		return SingletonRegistroConexiones.getInstancia().solicitarPuerto();
	}

	@Override
	public boolean conectarPaP(String idServidor, String ip,Integer puerto) {
		return SingletonRegistroConexiones.getInstancia().conectarPaP(idServidor,ip,puerto);
	}

	public ControladorAereo getAppControladorAereo() {
		return appControladorAereo;
	}

	public void setAppControladorAereo(ControladorAereo appControladorAereo) {
		this.appControladorAereo = appControladorAereo;
	}

	@Override
	public ITiempoDerivaSerializable sync(String fecha) {
		return SingletonRegistroConexiones.getInstancia().sync(fecha);
	}

}

package Middleware;

import java.rmi.RemoteException;
import ControladorAereo.ControladorAereo;
import RMIControladorAereo.ServidorControladorAereo;
import source.Configuracion;

public class Middleware {
	private ServidorControladorAereo servidorControladorAereo;
	private static ControladorAereo appControladorAereo;

	public Middleware(ControladorAereo appControladorAereo) {
		this.setAppControladorAereo(appControladorAereo);
		try {
			this.setServidorControladorAereo(
					new ServidorControladorAereo(Configuracion.ipServidor,Configuracion.puertoServidor,"ctrlAereo", appControladorAereo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ServidorControladorAereo getServidorControladorAereo() {
		return servidorControladorAereo;
	}

	public void setServidorControladorAereo(ServidorControladorAereo servidorControladorAereo) {
		this.servidorControladorAereo = servidorControladorAereo;
	}

	public static ControladorAereo getAppControladorAereo() {
		return appControladorAereo;
	}

	public void setAppControladorAereo(ControladorAereo appControladorAereo) {
		Middleware.appControladorAereo = appControladorAereo;
	}

}

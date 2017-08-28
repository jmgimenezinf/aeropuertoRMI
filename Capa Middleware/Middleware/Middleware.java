package Middleware;

import java.rmi.RemoteException;
import ControladorAereo.ControladorAereo;
import RMIControladorAereo.ServidorControladorAereo;

public class Middleware {
	private ServidorControladorAereo servidorControladorAereo;
	private ControladorAereo appControladorAereo;

	public Middleware(ControladorAereo appControladorAereo) {
		this.setAppControladorAereo(appControladorAereo);
	}

	public void inicializar() {
		try {
			this.setServidorControladorAereo(new ServidorControladorAereo(7556, "rmiCtrAereo", appControladorAereo));
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	public ServidorControladorAereo getServidorControladorAereo() {
		return servidorControladorAereo;
	}

	public void setServidorControladorAereo(ServidorControladorAereo servidorControladorAereo) {
		this.servidorControladorAereo = servidorControladorAereo;
	}

	public ControladorAereo getAppControladorAereo() {
		return appControladorAereo;
	}

	public void setAppControladorAereo(ControladorAereo appControladorAereo) {
		this.appControladorAereo = appControladorAereo;
	}

}

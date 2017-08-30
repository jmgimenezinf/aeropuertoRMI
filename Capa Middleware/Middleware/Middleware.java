package Middleware;

import java.rmi.RemoteException;
import ControladorAereo.ControladorAereo;
import RMIControladorAereo.ServidorControladorAereo;

public class Middleware {
	private ServidorControladorAereo servidorControladorAereo;
	private static ControladorAereo appControladorAereo;

	public Middleware(ControladorAereo appControladorAereo) {
		this.setAppControladorAereo(appControladorAereo);
		try {
			this.setServidorControladorAereo(
					new ServidorControladorAereo(7000,"ctrlAereo", appControladorAereo));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static ControladorAereo getAppControladorAereo() {
		return appControladorAereo;
	}

	public void setAppControladorAereo(ControladorAereo appControladorAereo) {
		Middleware.appControladorAereo = appControladorAereo;
	}

}

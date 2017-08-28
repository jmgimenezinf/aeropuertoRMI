package RMIAvion;

import java.rmi.RemoteException;

import Avion.AvionApli;
import Avion.IAvion;
import RMI.Servidor;

public class ServidorAvion extends Servidor implements IAvion {
	private AvionApli avionApli;
	private static final long serialVersionUID = 1L;

	protected ServidorAvion(Integer numeroPuertoRemoto,String nombreServidor) throws RemoteException {
		super(numeroPuertoRemoto,nombreServidor);
	}

	@Override
	public void pistaAsignada(Integer nroPista) {
		this.avionApli.pistaAsignada(nroPista);
	}

	@Override
	public void noHayPista(Integer nroTurno) {
		this.getAvionApli().noHayPista(nroTurno);
	}

	public AvionApli getAvionApli() {
		return avionApli;
	}

	public void setAvionApli(AvionApli avionApli) {
		this.avionApli = avionApli;
	}

}

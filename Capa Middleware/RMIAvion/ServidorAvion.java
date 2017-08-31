package RMIAvion;

import java.rmi.RemoteException;
import Avion.AvionApli;
import RMI.Servidor;
import RMIControladorAereo.IAvion;

public class ServidorAvion extends Servidor implements IAvion {
	private AvionApli avionApli;
	private static final long serialVersionUID = 1L;

	public ServidorAvion(String ip,Integer numeroPuertoRemoto,String nombreServidor) throws RemoteException {
		super(numeroPuertoRemoto,nombreServidor, ip);
	}

	@Override
	public void pistaAsignada(Integer nroPista) throws RemoteException{
		this.avionApli.pistaAsignada(nroPista);
	}

	@Override
	public void noHayPista(Integer nroTurno) throws RemoteException{
		this.getAvionApli().noHayPista(nroTurno);
	}

	public AvionApli getAvionApli() {
		return avionApli;
	}

	public void setAvionApli(AvionApli avionApli) {
		this.avionApli = avionApli;
	}

}

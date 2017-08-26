package RMIControladorAereo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.IAvion;
import RMI.Cliente;

public class ClienteControladorAereo extends Cliente implements RMIControladorAereo.IAvion {
	private IAvion servidorAvion;

	public ClienteControladorAereo(String ip, Integer puerto, String lookup) throws RemoteException, NotBoundException {
		super(ip, puerto);
		// TODO Auto-generated constructor stub
		this.inicializarControladorAereo(lookup);
	}

	private void inicializarControladorAereo(String lookup) {
		IAvion servidorAvion = null;
		try {
			servidorAvion = (IAvion) this.getRegistro().lookup(lookup);
		} catch (RemoteException | NotBoundException | ClassCastException e) {
			e.printStackTrace();
			System.out.println("cast exception");

		}
		this.setServidorAvion(servidorAvion);
	}

	public IAvion getServidorAvion() {
		return servidorAvion;
	}

	public void setServidorAvion(IAvion servidorAvion) {
		this.servidorAvion = servidorAvion;
	}

	@Override
	public void pistaAsignada(Integer nroPista) throws RemoteException {
		this.getServidorAvion().pistaAsignada(nroPista);
	}

	@Override
	public void noHayPista(Integer nroTurno) throws RemoteException {
		this.getServidorAvion().noHayPista(nroTurno);
	}

}

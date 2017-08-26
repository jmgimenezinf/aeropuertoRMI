package RMIAvionControladorAereoV1;

import java.rmi.RemoteException;

import AvionV1.Avion;
import AvionV1.IAvion;
import RMIV1.Servidor;

public class ServidorAvion extends Servidor implements IAvion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Avion avion;

	protected ServidorAvion(Integer numeroPuertoRemoto, Avion avion) throws RemoteException {
		super(numeroPuertoRemoto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pistaAsignada(Integer nroPista) {
		this.getAvion().pistaAsignada(nroPista);
	}

	@Override
	public void noHayPista(Integer nroTurno) {
		this.getAvion().noHayPista(nroTurno);
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.getAvion().getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

}

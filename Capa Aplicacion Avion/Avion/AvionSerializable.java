package Avion;

import java.rmi.RemoteException;

import ControladorAereoV1.ControladorAereo;
import RMIAvionControladorAereoV1.ClienteAvion;

public class AvionSerializable implements IAvionSerializable {

	private static final long serialVersionUID = -4923863081446539237L;
	private String nombre;
	private Integer turno;
	private Integer pistaAsignada;
	private boolean ejecutado = false;

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void pistaAsignada(Integer nroPista) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void noHayPista(Integer nroTurno) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}

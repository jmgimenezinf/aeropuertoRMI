package Avion;


import java.rmi.RemoteException;
import java.util.Random;

import ControladorAereoV1.ControladorAereo;
import RMIAvionControladorAereoV1.ClienteAvion;


public class Avion implements IAvion{
	private AvionSerializable avionPrueba;
	private String nombre;
	private Integer turno;
	private ClienteAvion clienteAvion;
	private Integer pistaAsignada;
	private ControladorAereo controladorAereo;
	private boolean ejecutado = false;

	public Avion(String nombre, ClienteAvion clienteAvion) {
		this.setNombre(nombre);
		this.setTurno(0);
		this.setClienteAvion(clienteAvion);
		
	}

	public void solicitarPista() throws RemoteException {
//		try {
//			this.getClienteAvion().solicitarPista((IAvionSerializable)this);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			avionPrueba = new AvionSerializable();
			avionPrueba.setNombre("inanicion");
			this.getClienteAvion().solicitarPista(avionPrueba);
			System.out.println("revienta en la clase avion solicitar pista");

		// this.getControladorAereo().solicitarPista(this);
	}
	@Override
	public void pistaAsignada(Integer nroPista) {
		this.setPistaAsignada(nroPista);

	}
	@Override
	public void noHayPista(Integer nroTurno) {
		this.setTurno(nroTurno);
		// pasa un tiempo nroTurno * tiempo
		// this.solicitarPista();
	}

	// getters y setter
	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	public ClienteAvion getClienteAvion() {
		return clienteAvion;
	}

	public void setClienteAvion(ClienteAvion clienteAvion) {
		this.clienteAvion = clienteAvion;
	}

	public Integer getPistaAsignada() {
		return pistaAsignada;
	}

	public void setPistaAsignada(Integer pistaAsignada) {
		this.pistaAsignada = pistaAsignada;
	}

	public ControladorAereo getControladorAereo() {
		return controladorAereo;
	}

	public void setControladorAereo(ControladorAereo controladorAereo) {
		this.controladorAereo = controladorAereo;
	}

}

package Avion;

import RMIAvion.ClienteAvion;
import java.rmi.RemoteException;


public class AvionApli implements IAvion{
	private String nombre;
	private Integer turno;
	private ClienteAvion clienteAvion;
	private Integer pistaAsignada;

	public AvionApli(String nombre, ClienteAvion clienteAvion) {
		this.setNombre(nombre);
		this.setTurno(0);
		this.setClienteAvion(clienteAvion);
	}

	public void solicitarPista(){
		try {
			this.getClienteAvion().solicitarPista(this.getNombre());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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


}

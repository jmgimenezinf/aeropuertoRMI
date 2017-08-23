package Avion;

import java.rmi.RemoteException;
import java.util.Random;
import ControladorAereo.ControladorAereo;
import RMIAvionControladorAereo.ClienteAvion;


public class Avion implements Runnable,IAvion {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	//ejecución de hilo
	public void run() {

		if (!ejecutado) {
			Random random = new Random();
			Integer segundosAleatorio = (random.nextInt(10));
			Integer milisegundos = segundosAleatorio * 1000;
			try {
				System.out.println("Avion " + this.getNombre() + " inactivo por " + segundosAleatorio + " Segundos");
				Thread.sleep(milisegundos);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.solicitarPista();
			ejecutado = true;
		}

	}

	// public Avion(ControladorAereo controladorAereo, String nombre) {
	// this.setControladorAereo(controladorAereo);
	// this.setNombre(nombre);
	// }
	
	public void solicitarPista() {
		try {
			this.getClienteAvion().solicitarPista(this);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	// getters y setters
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

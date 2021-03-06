package ControladorAereo;

import java.util.ArrayList;

import Avion.Avion;

public class ControladorAereo extends Thread implements IControladorAereo {
	private ArrayList<Pista> pistas = new ArrayList<Pista>();
	private Turnos turnos;
	private Integer cantidadAterrizajes = 0;

	public void run() {
		System.out.println("El controlador se esta ejecutando");
	}

	public ControladorAereo() {
		System.out.println("creando controlador ..");
		this.setTurnos(new Turnos());
		for (int i = 1; i <= 5; i++) {
			Pista pista = new Pista(i, this);
			this.getPistas().add(pista);
		}
		System.out.println("Pistas inicializadas");
	}

	public void avionAterrizado(Pista pista) {
		cantidadAterrizajes = cantidadAterrizajes + 1;
		System.out.println("");
		System.out.println("Pista :" + pista.getNumeroPista() + " Cantidad de aterrizajes : " + cantidadAterrizajes);
		System.out.println("");
		Avion avionConTurno = this.getTurnos().proximoTurno();
		if (avionConTurno != null) {
			pista.asignarPista(avionConTurno);
			avionConTurno.pistaAsignada(pista.getNumeroPista());
		}

	}

	public Pista buscarPistaDisponible() {
		Pista pistaDisponible = null;
		for (Pista pista : this.getPistas()) {
			if (pista.isDisponible()) {
				pistaDisponible = pista;
			}
		}
		return pistaDisponible;
	}

	public ArrayList<Pista> getPistas() {
		return pistas;
	}

	public void setPistas(ArrayList<Pista> pistas) {
		this.pistas = pistas;
	}

	public Turnos getTurnos() {
		return turnos;
	}

	public void setTurnos(Turnos turnos) {
		this.turnos = turnos;
	}

	public Integer getCantidadAterrizajes() {
		return this.cantidadAterrizajes;
	}

	@Override
	public void solicitarPista(Avion avion){
		System.out.println("");
		System.out.println(avion.getNombre() + " Solicitando Pista");
		System.out.println("");
		Pista pistaDisponible = buscarPistaDisponible();
		if (pistaDisponible != null) {
			avion.pistaAsignada(pistaDisponible.getNumeroPista());
			pistaDisponible.asignarPista(avion);
		} else {
			this.getTurnos().asignarTurno(avion);
		}

	}

}

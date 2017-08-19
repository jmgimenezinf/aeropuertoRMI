package ControladorAereo;
import java.util.PriorityQueue;
import java.util.Queue;

import Avion.Avion;

public class Turnos {
	private Queue<Avion> turnos = new PriorityQueue<Avion>();
	
	
	public Avion proximoTurno() {
		return this.getTurnos().poll();
	}
	
	public void asignarTurno(Avion avion) {
		this.getTurnos().add(avion);
		avion.setTurno(this.getTurnos().size());	
	}

	private Queue<Avion> getTurnos() {
		return turnos;
	}

	private void setTurnos(Queue<Avion> turnos) {
		this.turnos = turnos;
	}
	
}

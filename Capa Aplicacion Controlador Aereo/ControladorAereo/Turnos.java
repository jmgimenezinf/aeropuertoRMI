package ControladorAereo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import Avion.Avion;

public class Turnos {
	private Queue<Avion> turnos;

	static class ComparadorEmergencia implements Comparator<Avion> {

		public int compare(Avion one, Avion two) {
			return one.getHoraSolicitudPista().compareTo(two.getHoraSolicitudPista());
			
		}
	}

	public Turnos() {
		ComparadorEmergencia comparadorEmergencia = new ComparadorEmergencia();
		turnos = new PriorityQueue<Avion>(1000, comparadorEmergencia);
	}

	public Avion proximoTurno() {
		return this.getTurnos().poll();
	}

	public void asignarTurno(Avion avion) {
		this.getTurnos().add(avion);
		Integer turnoAsignado = this.getTurnos().size();
		avion.setTurno(turnoAsignado);
		avion.noHayPista(turnoAsignado);
		System.out.println("No hay pistas disponibles para el avión " + avion.getNombre() + " Turno n°" + turnoAsignado);
	}

	private Queue<Avion> getTurnos() {
		return turnos;
	}

}

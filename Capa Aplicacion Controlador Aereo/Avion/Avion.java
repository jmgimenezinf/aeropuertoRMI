package Avion;

import org.joda.time.DateTime;

public abstract class Avion implements IAvion{
	private Integer turno;
	private Integer pistaAsignada;
	private String nombre;
	private DateTime horaSolicitudPista;
	private int id = 0;
	public Integer getPistaAsignada() {
		return pistaAsignada;
	}
	public void setPistaAsignada(Integer pistaAsignada) {
		this.pistaAsignada = pistaAsignada;
	}
	public Integer getTurno() {
		return turno;
	}
	public void setTurno(Integer turno) {
		this.turno = turno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DateTime getHoraSolicitudPista() {
		return horaSolicitudPista;
	}
	public void setHoraSolicitudPista(DateTime horaSolicitudPista) {
		this.horaSolicitudPista = horaSolicitudPista;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}

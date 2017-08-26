package Avion;

public abstract class Avion implements IAvion{
	private Integer turno;
	private Integer pistaAsignada;
	private String nombre;

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
	
}

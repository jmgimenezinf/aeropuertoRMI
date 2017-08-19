package ControladorAereo;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;

import Avion.Avion;


public class Pista {
	private Integer numeroPista;
	private boolean disponible;
	private ControladorAereo controladorAereo;
	private Avion avion;
	private TiempoAterrizaje tiempoAterrizaje;
		
	public Pista(Integer numeroPista,ControladorAereo controladorAereo){
		this.setNumeroPista(numeroPista);
		this.setDisponible(true);
		this.setControladorAereo(controladorAereo);
		this.setTiempoAterrizaje(new TiempoAterrizaje(this));
	
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		
		this.disponible = disponible;
	}

	
	public void asignarPista(Avion avion){
		this.setAvion(avion);
		this.getTiempoAterrizaje().contarAterrizaje();
		System.out.println("Asignada pista N° " + this.getNumeroPista() + "al avión " + this.getAvion().getNombre());
		
	}

	public Integer getNumeroPista() {
		return numeroPista;
	}

	public void setNumeroPista(Integer numeroPista) {
		this.numeroPista = numeroPista;
	}
	
	public void finalizoAterrizaje(){
		this.setDisponible(true);
		this.getControladorAereo().pistaDisponible(this);
		
		
	}

	public ControladorAereo getControladorAereo() {
		return controladorAereo;
	}

	public void setControladorAereo(ControladorAereo controladorAereo) {
		this.controladorAereo = controladorAereo;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public TiempoAterrizaje getTiempoAterrizaje() {
		return tiempoAterrizaje;
	}

	public void setTiempoAterrizaje(TiempoAterrizaje tiempoAterrizaje) {
		this.tiempoAterrizaje = tiempoAterrizaje;
	}
	
}

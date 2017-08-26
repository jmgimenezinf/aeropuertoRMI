package ControladorAereoV1;

import AvionV1.Avion;

public class Pista {
	private Integer numeroPista;
	private boolean disponible;
	private ControladorAereo controladorAereo;
	private Avion avion;
	private TiempoAterrizaje tiempoAterrizaje;

	public Pista(Integer numeroPista, ControladorAereo controladorAereo) {
		this.setNumeroPista(numeroPista);
		this.setDisponible(true);
		this.setControladorAereo(controladorAereo);
	}

	public void asignarPista(Avion avion) {
		this.setAvion(avion);
		this.setDisponible(false);
		System.out.println("Asignada pista N° " + this.getNumeroPista() + "al avión " + this.getAvion().getNombre());
		Thread subproceso = new Thread(new TiempoAterrizaje(this));
		subproceso.start();
	}

	public Integer getNumeroPista() {
		return numeroPista;
	}

	public void setNumeroPista(Integer numeroPista) {
		this.numeroPista = numeroPista;
	}

	public void finalizoAterrizaje() {
		this.setDisponible(true);
		this.getControladorAereo().avionAterrizado(this);
		System.out.println(
				"Avion " + this.getAvion().getNombre() + " aterrizado, disponible la pista N°" + this.getNumeroPista());

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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {

		this.disponible = disponible;
	}

}

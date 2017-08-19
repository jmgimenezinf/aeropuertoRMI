package ControladorAereo;

import java.util.Timer;



public class TiempoAterrizaje {
	
	private Timer timer = new Timer();
	private static long tiempoAterrizaje =30;
	private Pista pista;
	
	public TiempoAterrizaje(Pista pista){
		this.setPista(pista);
		
	}
	
	public void contarAterrizaje(){
		try {
			this.getTimer().wait(this.getTiempoAterrizaje());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getPista().finalizoAterrizaje();
	}

	private long getTiempoAterrizaje() {
		return tiempoAterrizaje;
	}


	private Timer getTimer() {
		return timer;
	}

	private void setTimer(Timer timer) {
		this.timer = timer;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}
	
	

	
	
}

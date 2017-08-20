package ControladorAereo;

public class TiempoAterrizaje implements Runnable{
	
	private static long tiempoAterrizaje =4000;
	private Pista pista;

	
	public TiempoAterrizaje(Pista pista){
		this.setPista(pista);
		
	}
	
	public void contarAterrizaje(){
		try {
			Thread.sleep(this.getTiempoAterrizaje());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getPista().finalizoAterrizaje();
	}

	private long getTiempoAterrizaje() {
		return tiempoAterrizaje;
	}


	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}


	@Override
	public void run() {
		this.contarAterrizaje();
	}

	
	
}

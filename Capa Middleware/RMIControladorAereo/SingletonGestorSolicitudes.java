package RMIControladorAereo;

public class SingletonGestorSolicitudes {
	private static SingletonGestorSolicitudes instancia=null;

	public static SingletonGestorSolicitudes getInstancia() {
		if (instancia == null) {
			instancia = new SingletonGestorSolicitudes();
		}
		return instancia;
	}

	
}

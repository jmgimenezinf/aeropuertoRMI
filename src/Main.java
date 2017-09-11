
import org.joda.time.DateTime;

import Avion.AvionLocal;
import ControladorAereo.ControladorAereo;
import Middleware.Middleware;

public class Main {

	public static void main(String[] args) {
		ControladorAereo controladorAereo = new ControladorAereo();
		controladorAereo.start();
		@SuppressWarnings("unused")
		Middleware middleware = new Middleware(controladorAereo);
		
		for (int i=1 ; i<=5;i++){
			AvionLocal avion = new AvionLocal(Integer.toString(i));
			DateTime dateTime = new DateTime();
			avion.setHoraSolicitudPista(dateTime);
			controladorAereo.solicitarPista(avion);
		}
	}

}

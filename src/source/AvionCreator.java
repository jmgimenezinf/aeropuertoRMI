package source;
import org.joda.time.DateTime;

import Avion.AvionLocal;
import Avion.AvionRemoto;
import RMIControladorAereo.ClienteControladorAereo;

public class AvionCreator {

	
	public static AvionLocal crearAvionLocal(String nombre) {
		AvionLocal avion = new AvionLocal(nombre);
		return avion;
	}
	public static AvionRemoto crearAvionRemoto(String nombre,
			ClienteControladorAereo cteCtrlAereo,DateTime horaSolicitudPista) {
		AvionRemoto avion = new AvionRemoto(nombre,cteCtrlAereo);
		avion.setHoraSolicitudPista(horaSolicitudPista);
		return avion;
	}
}

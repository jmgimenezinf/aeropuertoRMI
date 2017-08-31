package source;
import Avion.AvionLocal;
import Avion.AvionRemoto;
import RMIControladorAereo.ClienteControladorAereo;

public class AvionCreator {

	
	public static AvionLocal crearAvionLocal(String nombre) {
		AvionLocal avion = new AvionLocal(nombre);
		return avion;
	}
	public static AvionRemoto crearAvionRemoto(String nombre,
			ClienteControladorAereo cteCtrlAereo) {
		AvionRemoto avion = new AvionRemoto(nombre,cteCtrlAereo);
		return avion;
	}
}

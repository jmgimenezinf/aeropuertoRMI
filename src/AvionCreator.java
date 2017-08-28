import Avion.Avion;
import Avion.AvionLocal;
import Avion.AvionRemoto;
import RMIControladorAereo.ClienteControladorAereo;

public class AvionCreator {

	
	public static Avion crearAvionLocal(String nombre) {
		AvionLocal avion = new AvionLocal(nombre);
		return avion;
	}
	public static Avion crearAvionRemoto(String nombre,
			ClienteControladorAereo cteCtrlAereo) {
		AvionRemoto avion = new AvionRemoto(nombre,cteCtrlAereo);
		return avion;
	}
}

import Avion.Avion;
import Avion.AvionLocal;
import Avion.AvionRemoto;

public class AvionCreator {

	
	public static Avion crearAvionLocal(String nombre) {
		AvionLocal avion = new AvionLocal(nombre);
		return avion;
	}
	public static Avion crearAvionRemoto(String nombre,String ip,Integer puerto) {
		AvionRemoto avion = new AvionRemoto(ip,puerto,nombre);
		return avion;
	}
}

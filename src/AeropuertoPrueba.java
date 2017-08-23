import Avion.Avion;
import ControladorAereo.ControladorAereo;

public class AeropuertoPrueba {

	public static void main(String[] args) {
		ControladorAereo controladorAereo = new ControladorAereo();
		controladorAereo.start();
		for (int i=1 ; i<=100;i++){
		//	Avion avion = new Avion(controladorAereo,Integer.toString(i));
		//	avion.run();
		}

	}

}

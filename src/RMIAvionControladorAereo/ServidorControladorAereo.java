package RMIAvionControladorAereo;

import java.rmi.RemoteException;

import Avion.Avion;
import Avion.IAvion;
import Avion.IAvionSerializable;
import ControladorAereo.ControladorAereo;
import ControladorAereo.IControladorAereo;
import RMI.Servidor;

public class ServidorControladorAereo extends Servidor implements IControladorAereo {

	private static final long serialVersionUID = 1L;
	private ControladorAereo controladorAereo;

	public ServidorControladorAereo(Integer numeroPuertoRemoto) throws RemoteException {
		super(numeroPuertoRemoto);
		this.inicializarControladorAereo();
	}
	private void inicializarControladorAereo(){
		this.setControladorAereo(new ControladorAereo());
	}
	@Override
	public void solicitarPista(IAvionSerializable avion) throws RemoteException{
		this.getControladorAereo().solicitarPista(avion);
	}

	private ControladorAereo getControladorAereo() {
		return controladorAereo;
	}

	private void setControladorAereo(ControladorAereo controladorAereo) {
		this.controladorAereo = controladorAereo;
	}
	@Override
	public void mensajeDePrueba(IAvionSerializable avion) throws RemoteException {
		System.out.println("Llego correctamente el " + avion.getNombre());
		
	}

}
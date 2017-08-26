package RMIAvionControladorAereoV1;

import java.rmi.RemoteException;

import AvionV1.Avion;
import AvionV1.IAvion;
import AvionV1.IAvionSerializable;
import ControladorAereoV1.ControladorAereo;
import ControladorAereoV1.IControladorAereo;
import RMIV1.Servidor;

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
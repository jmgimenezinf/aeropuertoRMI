package RMIAvionControladorAereo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.Avion;
import Avion.IAvion;
import Avion.IAvionSerializable;
import ControladorAereo.IControladorAereo;
import RMI.Cliente;

public class ClienteAvion extends Cliente implements IControladorAereo{
	private IControladorAereo servidorControladorAereo;

	public ClienteAvion(String ip, Integer puerto) throws RemoteException, NotBoundException {
		super(ip, puerto);
		this.inicializarControladorAereo();
	}
	
	private void inicializarControladorAereo() {
		IControladorAereo controladorAereoRemoto = null;
		try {
			controladorAereoRemoto = (IControladorAereo)this.getRegistro().lookup("rmiServidor");
		} catch (RemoteException | NotBoundException | ClassCastException e) {
			e.printStackTrace();
			System.out.println("cast exception");
	
		}
		this.setServidorControladorAereo(controladorAereoRemoto);
	}


	private IControladorAereo getServidorControladorAereo() {
		return servidorControladorAereo;
	}

	private void setServidorControladorAereo(IControladorAereo servidorControladoraAereo) {
		this.servidorControladorAereo = servidorControladoraAereo;
	}

	@Override
	public void mensajeDePrueba(IAvionSerializable avion) throws RemoteException {
		this.getServidorControladorAereo().mensajeDePrueba(avion);
		
	}

	@Override
	public void solicitarPista(IAvionSerializable avion) throws RemoteException {
		
			this.getServidorControladorAereo().solicitarPista(avion);

	}

}

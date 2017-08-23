package RMIAvionControladorAereo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Avion.Avion;
import Avion.IAvion;
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
	public void mensajeDePrueba() throws RemoteException {
		this.getServidorControladorAereo().mensajeDePrueba();
		
	}

	@Override
	public void solicitarPista(IAvion avion) throws RemoteException {
		try {
			System.out.println(avion.getNombre());
			this.getServidorControladorAereo().solicitarPista(avion);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

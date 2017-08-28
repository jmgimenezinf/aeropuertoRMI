package RMIAvion;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMI.Cliente;

public class ClienteAvion extends Cliente implements RMIAvion.IControladorAereo{
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
	public void solicitarPista(String nombreAvion) throws RemoteException {
		this.getServidorControladorAereo().solicitarPista(nombreAvion);
	}


}
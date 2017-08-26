package RMIV1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public abstract class Cliente {

	public Registry registro;
	public String direccionServidor;
	public Integer puertoServidor;

	public Cliente(String ip, Integer puerto) throws RemoteException, NotBoundException {
		direccionServidor = ip;
		puertoServidor = puerto;
		this.conectarseAlServidor();
	}

	protected void conectarseAlServidor() {
		// Obtener registro
		try {
			this.setRegistro(LocateRegistry.getRegistry(direccionServidor, puertoServidor));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	protected Registry getRegistro() {
		return registro;
	}

	protected void setRegistro(Registry registro) {
		this.registro = registro;
	}
	/**
	 * Ejemplo de cómo debe crear el objeto remoto las clases hijas try {
	 * setServidorCtrAereo((IControladorAereo)
	 * (registro.lookup("rmiServidorCtrAereo"))); } catch (RemoteException |
	 * NotBoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 **/
}

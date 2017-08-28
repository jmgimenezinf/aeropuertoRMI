package RMIControladorAereo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

public class SingletonRegistroConexiones implements IConexionPaP {
	private static SingletonRegistroConexiones instancia = null;
	private HashMap<Integer, ClienteControladorAereo> puertoCliente;

	@Override
	public Integer solicitarPuerto() {
		if (!this.getPuertoCliente().isEmpty()) {
			this.getPuertoCliente().put(10000, null);
			return 10000;
		} else {
			this.getPuertoCliente().put(this.getPuertoCliente().size(), null);
			return 10000 + this.getPuertoCliente().size();
		}
	}

	@Override
	public boolean conectarPaP(String idServidorAvion, Integer puerto) {
		ClienteControladorAereo cltCtrAereo = null;
		try {
			cltCtrAereo = new ClienteControladorAereo("127.0.0.1", puerto, idServidorAvion);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		this.getPuertoCliente().put(puerto,cltCtrAereo);
		return true;
	}

	public HashMap<Integer, ClienteControladorAereo> getPuertoCliente() {
		return puertoCliente;
	}

	public void setPuertoCliente(HashMap<Integer, ClienteControladorAereo> puertoCliente) {
		this.puertoCliente = puertoCliente;
	}

	public static SingletonRegistroConexiones getInstancia() {
		if (instancia == null) {
			instancia = new SingletonRegistroConexiones();
		}
		return instancia;
	}

}

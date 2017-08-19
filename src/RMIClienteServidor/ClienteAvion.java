package RMIClienteServidor;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ControladorAereo.IControladorAereo;

public class ClienteAvion {

	private IControladorAereo rmiServidorCtrAereo;
	private Registry registro;
	private String direccionServidor;
	private Integer puertoServidor;
	
	public ClienteAvion (String ip, Integer puerto) throws RemoteException, NotBoundException {
		direccionServidor =ip;
		puertoServidor = puerto;
		this.conectarseAlServidor();
	}
	
	public void conectarseAlServidor() {
		//Obtener registro
		try {
			registro = LocateRegistry.getRegistry(direccionServidor,puertoServidor);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//creando el objeto remoto
		try {
			setRmiServidorCtrAereo((IControladorAereo)
					(registro.lookup("rmiServidorCtrAereo")));
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public IControladorAereo getRmiServidorCtrAereo() {
		return rmiServidorCtrAereo;
	}

	public void setRmiServidorCtrAereo(IControladorAereo rmiServidorCtrAereo) {
		this.rmiServidorCtrAereo = rmiServidorCtrAereo;
	}
	
	
}

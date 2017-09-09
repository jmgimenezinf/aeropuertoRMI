package Middleware;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import RMIControladorAereo.ClienteControladorAereo;
import RMIControladorAereo.IConexionPaP;

public class SingletonRegistroConexiones implements IConexionPaP {
	private static SingletonRegistroConexiones instancia = null;
	private HashMap<Integer, ClienteControladorAereo> puertoCliente;
	private static Integer minPort = 10000;
	private static Integer maxPort = 10500;

	public SingletonRegistroConexiones() {
		this.setPuertoCliente(new HashMap<Integer, ClienteControladorAereo>());
		for (int i = 0; i < maxPort - minPort; i++) {
			this.getPuertoCliente().put(i, null);
		}

	}

	@Override
	public Integer solicitarPuerto() {
		Integer puerto = buscarPuerto();
		return puerto;
	}

	private Integer buscarPuerto() {
		Integer puerto = minPort + (int) (Math.random() * maxPort);
		while (!(this.getPuertoCliente().get(puerto) == null)) {
			puerto = minPort + (int) (Math.random() * maxPort);
		}
		System.out.println("El puerto es asignado es: " + puerto);
		return puerto;
	}

	@Override
	public boolean conectarPaP(String idServidorAvion,String ip,Integer puerto) {
		ClienteControladorAereo cltCtrAereo = null;
		try {
			cltCtrAereo = new ClienteControladorAereo(ip, puerto, idServidorAvion);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		this.getPuertoCliente().put(puerto, cltCtrAereo);
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

	@Override
	public ITiempoDerivaSerializable sync(String fecha) {
		return SingletonNTP.getInstancia().sync(fecha);
	}

}

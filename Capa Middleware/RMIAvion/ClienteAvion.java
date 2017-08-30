package RMIAvion;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMI.Cliente;
import RMIControladorAereo.IConexionPaP;

public class ClienteAvion extends Cliente implements RMIAvion.IControladorAereo, IConexionPaP{
	private IControladorAereo servidorControladorAereo;
	private IConexionPaP servidorConexion;
	private Integer puerto;
	
	public ClienteAvion(String ip, Integer puerto) throws RemoteException, NotBoundException {
		super(ip, puerto);
		this.inicializarServidorConexion();
		this.inicializarControladorAereo();
	}
	
	private void inicializarControladorAereo() {
		IControladorAereo controladorAereoRemoto = null;
		try {
			controladorAereoRemoto = (IControladorAereo)this.getRegistro().lookup("ctrlAereo");
		} catch (RemoteException | NotBoundException | ClassCastException e) {
			e.printStackTrace();
			System.out.println("cast exception");
			
	
		}
		this.setServidorControladorAereo(controladorAereoRemoto);
	}
	private void inicializarServidorConexion() {
		IConexionPaP servidorConexion = null;
		try {
			servidorConexion = (IConexionPaP)this.getRegistro().lookup("ctrlAereo");
		} catch (RemoteException | NotBoundException | ClassCastException e) {
			e.printStackTrace();
			System.out.println("cast exception");
			
	
		}
		this.setServidorConexion(servidorConexion);
	}

	private IControladorAereo getServidorControladorAereo() {
		return servidorControladorAereo;
	}

	private void setServidorControladorAereo(IControladorAereo servidorControladoraAereo) {
		this.servidorControladorAereo = servidorControladoraAereo;
	}

	@Override
	public void solicitarPista(String nombreAvion,Integer puerto) throws RemoteException {
		this.getServidorControladorAereo().solicitarPista(nombreAvion,puerto);
	}

	@Override
	public Integer solicitarPuerto() throws RemoteException {
		return this.getServidorConexion().solicitarPuerto();
	}

	@Override
	public boolean conectarPaP(String idServidor, Integer puerto) throws RemoteException {
		boolean conectado = this.getServidorConexion().conectarPaP(idServidor, puerto);
		return conectado;
	}

	public IConexionPaP getServidorConexion() {
		return servidorConexion;
	}

	public void setServidorConexion(IConexionPaP servidorConexion) {
		this.servidorConexion = servidorConexion;
	}

	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}


}
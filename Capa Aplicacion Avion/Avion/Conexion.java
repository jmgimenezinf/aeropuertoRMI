package Avion;

import java.rmi.RemoteException;

import RMIAvion.ServidorAvion;
import RMIControladorAereo.IConexionPaP;

public class Conexion implements IConexionPaP{
	private Integer puerto;
	private AvionApli app;
	public Conexion (AvionApli app) {
		this.setApp(app);
	}
	
	@Override
	public Integer solicitarPuerto() {
		try {
			this.setPuerto(this.getApp().getClienteAvion().solicitarPuerto());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.getPuerto();
	}

	@Override
	public boolean conectarPaP(String idServidor,String ip,Integer puerto) {
		ServidorAvion servidorAvion=null;
		try {
			servidorAvion = new ServidorAvion(ip,puerto,this.getApp().getNombre());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		servidorAvion.setAvionApli(this.getApp());
		this.setPuerto(puerto);
		try {
			this.getApp().getClienteAvion().conectarPaP(idServidor,ip, puerto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Integer getPuerto() {
		return puerto;
	}

	public void setPuerto(Integer puerto) {
		this.puerto = puerto;
	}

	public AvionApli getApp() {
		return app;
	}

	public void setApp(AvionApli app) {
		this.app = app;
	}

}

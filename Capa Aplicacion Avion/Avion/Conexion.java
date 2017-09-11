package Avion;

import java.rmi.RemoteException;

import source.Configuracion;
import Middleware.ITiempoDerivaSerializable;
import RMIAvion.ServidorAvion;
import RMIControladorAereo.IConexionPaP;

public class Conexion implements IConexionPaP{
	private Integer puerto;
	private AvionApli app;
	private RelojVirtual relojVirtual;
	
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

	
	public ITiempoDerivaSerializable sync(String fecha) throws RemoteException {
		this.setRelojVirtual(new RelojVirtual(fecha));
		ITiempoDerivaSerializable relojServidor = this.getApp().getClienteAvion().sync(fecha);
		System.out.println("");
		System.out.println("La hora del servidor es : " + relojServidor.getFecha());
		System.out.println("");
		System.out.println("La deriva es : " + relojServidor.getDeriva()+" ms");
		while (relojServidor.getDeriva()> Configuracion.maxDeriva){
			this.getRelojVirtual().actualizarHoraLocal(relojServidor.getFecha());
			this.getRelojVirtual().setDeriva(relojServidor.getDeriva());
			relojServidor = this.getApp().getClienteAvion().sync(this.getRelojVirtual().horaMasDeriva());
			System.out.println("");
			System.out.println("La deriva mas ajustada es: "+ relojServidor.getDeriva() +" ms");
		}
		this.getRelojVirtual().setDeriva(relojServidor.getDeriva());
		return relojServidor;

	}

	public RelojVirtual getRelojVirtual() {
		return relojVirtual;
	}

	public void setRelojVirtual(RelojVirtual relojVirtual) {
		this.relojVirtual = relojVirtual;
	}


}

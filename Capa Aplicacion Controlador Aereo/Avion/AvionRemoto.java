package Avion;

import java.rmi.RemoteException;

import Consultas.ConsultasSQL;
import RMIControladorAereo.ClienteControladorAereo;

public class AvionRemoto extends Avion{
	private ClienteControladorAereo cltCtrlAereo;
	
	public AvionRemoto(String nombre,
			ClienteControladorAereo cltCtrAereo) {
		this.setNombre(nombre);
		this.setCltCtrlAereo(cltCtrAereo);
	}
	@Override
	public void pistaAsignada(Integer nroPista){
		ConsultasSQL.getInstancia().aterrizando(this,nroPista);
		System.out.println("Se le asigno la pista:"+nroPista + " Al avion: " + this.getNombre());
		try {
			this.getCltCtrlAereo().pistaAsignada(nroPista);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void noHayPista(Integer nroTurno) {
		this.setTurno(nroTurno);
		try {
			this.getCltCtrlAereo().noHayPista(nroTurno);
			ConsultasSQL.getInstancia().agregarTurno(this,(int)nroTurno);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private ClienteControladorAereo getCltCtrlAereo() {
		return cltCtrlAereo;
	}
	private void setCltCtrlAereo(ClienteControladorAereo cltCtrlAereo) {
		this.cltCtrlAereo = cltCtrlAereo;
	}


}

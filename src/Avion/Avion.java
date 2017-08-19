package Avion;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIClienteServidor.ClienteAvion;

public class Avion implements IAvion{
private String nombre; 
private Integer turno;
private ClienteAvion clienteAvion;
private Integer pistaAsignada;

public Avion(String nombre , String ip, Integer puerto) {
	this.setNombre(nombre);
	this.setTurno(0);
	//esperar un tiempo aleatorio
	try {
		this.setClienteAvion(new ClienteAvion(ip, puerto));
	} catch (RemoteException | NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void solicitarPista() {	
	this.getClienteAvion().getRmiServidorCtrAereo().solicitarPista(this);
}




@Override
public void pistaAsignada(Integer nroPista ) {
	this.setPistaAsignada(nroPista);
	this.getClienteAvion().getRmiServidorCtrAereo().aterrizando(this);
	
}




@Override
public void noHayPista(Integer nroTurno) {
	this.setTurno(nroTurno);
	//pasa un tiempo nroTurno * tiempo
	this.solicitarPista();


}




// getters y setters
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public Integer getTurno() {
	return turno;
}
public void setTurno(Integer turno) {
	this.turno = turno;
}

public ClienteAvion getClienteAvion() {
	return clienteAvion;
}

public void setClienteAvion(ClienteAvion clienteAvion) {
	this.clienteAvion = clienteAvion;
}

public Integer getPistaAsignada() {
	return pistaAsignada;
}

public void setPistaAsignada(Integer pistaAsignada) {
	this.pistaAsignada = pistaAsignada;
}





}

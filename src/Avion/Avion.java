package Avion;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Random;
import java.util.Timer;
import ControladorAereo.ControladorAereo;
import RMIClienteServidor.ClienteAvion;

public class Avion implements IAvion,Runnable {
private String nombre; 
private Integer turno;
private ClienteAvion clienteAvion;
private Integer pistaAsignada;
private Timer timer;
private ControladorAereo controladorAereo;
private boolean ejecutado=false;
public void run() {

	if(!ejecutado) {
	Random random = new Random();	
	Integer segundosAleatorio = (random.nextInt(10));
	Integer milisegundos = segundosAleatorio * 1000;
	try {
		System.out.println("Avion " +this.getNombre() +" inactivo por "+ segundosAleatorio + " Segundos");
		Thread.sleep(milisegundos);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	this.solicitarPista();
	ejecutado=true;
	}
	
}

public Avion (ControladorAereo controladorAereo , String nombre) {
	this.setControladorAereo(controladorAereo);;
	this.setNombre(nombre);
}

public Avion(String nombre , String ip, Integer puerto) {
	this.setNombre(nombre);
	this.setTurno(0);
	try {
		this.setClienteAvion(new ClienteAvion(ip, puerto));
	} catch (RemoteException | NotBoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void solicitarPista() {	
	//this.getClienteAvion().getRmiServidorCtrAereo().solicitarPista(this);
	this.getControladorAereo().solicitarPista(this);
}


@Override
public void pistaAsignada(Integer nroPista ) {
	this.setPistaAsignada(nroPista);
	
}




@Override
public void noHayPista(Integer nroTurno) {
	this.setTurno(nroTurno);
	//pasa un tiempo nroTurno * tiempo
	//this.solicitarPista();


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

public Timer getTimer() {
	return timer;
}

public void setTimer(Timer timer) {
	this.timer = timer;
}

public ControladorAereo getControladorAereo() {
	return controladorAereo;
}

public void setControladorAereo(ControladorAereo controladorAereo) {
	this.controladorAereo = controladorAereo;
}





}

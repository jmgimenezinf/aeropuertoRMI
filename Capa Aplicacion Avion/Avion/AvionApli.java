package Avion;

import RMIAvion.ClienteAvion;
import source.Configuracion;

import java.rmi.RemoteException;


public class AvionApli implements IAvion{
	private String nombre;
	private Integer turno;
	private ClienteAvion clienteAvion;
	private Integer pistaAsignada;
	private Conexion conexion;

	public AvionApli(String nombre, ClienteAvion clienteAvion) {
		this.setNombre(nombre);
		this.setTurno(0);
		this.setClienteAvion(clienteAvion);
		this.setConexion(new Conexion(this));
		this.getConexion().solicitarPuerto();
		if (this.getConexion().conectarPaP(this.getNombre(),Configuracion.ipCliente,
				this.getConexion().getPuerto())) {
			System.out.println("Conectado por el puerto" + this.getConexion().getPuerto());
		}else {
			System.out.println("Erro de conexión punto a punto");
		}
	}

	public void solicitarPista(){
		try {
			this.getClienteAvion().solicitarPista(this.getNombre(),this.getConexion().getPuerto());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void pistaAsignada(Integer nroPista) {
		this.setPistaAsignada(nroPista);
		System.out.println("Recibio: Asignada pista N°"+ 
		nroPista + " Desde :"+this.getNombre()+ " Respuesta: Despegando...");
	}
	@Override
	public void noHayPista(Integer nroTurno) {
		this.setTurno(nroTurno);
		System.out.println("Recibio:No hay pista disponible. Turno: "+ nroTurno + " Desde :"+this.getNombre() +
				" Respuesta: Esperaré "+ nroTurno * 30 + " segundos");
		// pasa un tiempo nroTurno * tiempo
		// this.solicitarPista();
	}

	// getters y setter
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

	public Conexion getConexion() {
		return conexion;
	}

	public void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}


}

package RMIControladorAereo;

public interface IConexionPaP {
	public Integer solicitarPuerto();
	public boolean conectarPaP(String idServidor,Integer puerto);
	
}

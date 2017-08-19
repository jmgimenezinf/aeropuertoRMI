package ControladorAereo;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Timer;

import Avion.Avion;


public class Pista {
	private boolean disponible;
	private Timer tiempoAsignacion; 
	private Avion ultimoAvion;
	private Queue<Turnos> turnos;
	private Byte mensaje;
	
}

package ControladorAereo;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import Avion.Avion;


public class ControladorAereo implements IControladorAereo{
	private ArrayList <Pista> pistas;


	public void solicitarPista(Avion avion) {
		System.out.println(avion.getNombre() + " Solicitando Pista");
		Pista pistaDisponible= buscarPistaDisponible();
		if (pistaDisponible!=null){
			//Avisarle al avion remoto que tiene asignada una pista.
			avion.pistaAsignada(pistaDisponible.getNumeroPista());
			pistaDisponible.asignarPista(avion);
			
		} else{
			avion.noHayPista(1);
		}
		
		
	}

	@Override
	public void aterrizando(Avion avion) {
		// TODO Auto-generated method stub
		
	}

	public void pistaDisponible(Pista pista){
		
	}
	
	public Pista buscarPistaDisponible(){
		 for (Pista pista : this.getPistas()) {
			 if(pista.isDisponible()){
				 return pista;//Devuelve la primer pista disponible.
			 	}
		 }
		 return null; //No hay pista disponible.
	}

	public ArrayList <Pista> getPistas() {
		return pistas;
	}

	public void setPistas(ArrayList <Pista> pistas) {
		this.pistas = pistas;
	}

}

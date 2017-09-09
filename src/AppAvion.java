import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

import Avion.AvionApli;
import Middleware.ITiempoDerivaSerializable;
import RMIAvion.ClienteAvion;
import source.Configuracion;

public class AppAvion {

	public static void main(String[] args) {
		ClienteAvion cliente=null;
		try {
			cliente = new ClienteAvion(Configuracion.ipServidor,7000);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AvionApli avion = new AvionApli("Avion77",cliente);
		avion.solicitarPista();
//		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		Date dateActual = new Date();
//
//	    String fecha = formato.format(dateActual);
//	    fecha= "2017-09-09 12:48:36.472";
//	    System.out.println(fecha);
//		ITiempoDerivaSerializable td=null;
//		try {
//			td = avion.getConexion().sync(fecha);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("fecha del servidor : " + td.getFecha());
//		System.out.println("Deriva dek servidor en segundos:"+ (float)Math.pow(10,-3)* td.getDeriva());
//		//System.out.println(date12);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	//	System.out.println(date12);
	}

}

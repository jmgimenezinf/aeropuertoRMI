package Middleware;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

import source.Configuracion;

public class SingletonNTP {
	private static SingletonNTP instancia = null;
	private long deriva;
	private Integer cantConexiones;

	public SingletonNTP() {
		this.setDeriva(0);
		this.setCantConexiones(0);
	}

	public static SingletonNTP getInstancia() {
		if (instancia == null) {
			instancia = new SingletonNTP();
		}
		return instancia;
	}

	public long getDeriva() {
		return deriva;
	}

	public void setDeriva(long deriva) {
		this.deriva = deriva;
	}

	public Integer getCantConexiones() {
		return cantConexiones;
	}

	public void setCantConexiones(Integer cantConexiones) {
		this.cantConexiones = cantConexiones;
	}

	public ITiempoDerivaSerializable sync(String fechaCliente) {
		TiempoDeriva tiempoDeriva = new TiempoDeriva();

		SimpleDateFormat formatoFecha = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		Date fechaActualServidor = new Date();
		String fechaActualServidorString = formatoFecha
				.format(fechaActualServidor);
		tiempoDeriva.setFecha(fechaActualServidorString);
		tiempoDeriva.setDeriva(calcularDeriva(fechaCliente,
				fechaActualServidorString));
		System.out.println("cantidad de conexiones = " + getCantConexiones());
		return tiempoDeriva;
	}

	private long calcularDeriva(String fechaCliente, String fechaServidor) {
		this.setCantConexiones(this.getCantConexiones() + 1);
		long intervalo = intervaloTiempo(fechaCliente, fechaServidor);
		if (intervalo > Configuracion.maxDeriva) {
			return intervalo;
		} else {
			this.setDeriva(this.getDeriva()
					+ intervaloTiempo(fechaCliente, fechaServidor)
					/ this.getCantConexiones());
			return this.getDeriva();
		}

	}

	private long intervaloTiempo(String fechaCliente, String fechaServidor) {
		SimpleDateFormat formato = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = formato.parse(fechaCliente);
			date2 = formato.parse(fechaServidor);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DateTime dateTime1 = new DateTime(date1);
		DateTime dateTime2 = new DateTime(date2);
		System.out.println("aca se rompio : " + dateTime1 + " y " + dateTime2);
		Interval interval;
		if (dateTime1.compareTo(dateTime2) == -1) {
			interval = new Interval(dateTime1, dateTime2);
		} else {
			interval = new Interval(dateTime2, dateTime1);
		}
		Duration duration = interval.toDuration();
		System.out.println("duration : " + duration);
		return duration.getMillis();
	}

}

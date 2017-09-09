package Avion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;

public class RelojVirtual {
	
	private long diferencia;
	private String horaServidor;
	private String horaLocal;
	private long deriva; 
	
	public RelojVirtual(String horaLocal){
		this.setHoraLocal(horaLocal);
	}
	public String getHoraServidor() {
		return horaServidor;
	}
	public void setHoraServidor(String horaServidor) {
		this.horaServidor = horaServidor;
	}
	public long getDiferencia() {
		return diferencia;
	}
	public void setDiferencia(long diferencia) {
		this.diferencia = diferencia;
	}
	public String getHoraLocal() {
		return horaLocal;
	}
	public void setHoraLocal(String horaLocal) {
		this.horaLocal = horaLocal;
	}
	public void actualizarHoraLocal(String relojServidor){
		System.out.println("Hora Local: "+ this.getHoraLocal());
		DateTime dateServidor = new DateTime(this.stringToDate(relojServidor));
		DateTime dateLocal = new DateTime(this.stringToDate(this.getHoraLocal()));
		if (dateServidor.getHourOfDay()>dateLocal.getHourOfDay()){
			int diffHora;
			diffHora = dateServidor.getHourOfDay() - dateLocal.getHourOfDay();
			dateLocal.plusHours(diffHora);
			
		}else{
			int diffHora;
			diffHora = dateLocal.getHourOfDay()- dateServidor.getHourOfDay();
			dateLocal.minusHours(diffHora);
		}
		
		if (dateServidor.getMinuteOfDay()>dateLocal.getMinuteOfDay()){
			int diffMin;
			diffMin = dateServidor.getMillisOfDay() - dateLocal.getMinuteOfDay();
			dateLocal.plusMinutes(diffMin);
			
		}else{
			int diffMin;
			diffMin = dateLocal.getMillisOfDay()- dateServidor.getMinuteOfDay();
			dateLocal.minusMinutes(diffMin);
		}
		
		if (dateServidor.getSecondOfDay()>dateLocal.getSecondOfDay()){
			int diffSeg;
			diffSeg = dateServidor.getSecondOfDay() - dateLocal.getSecondOfDay();
			dateLocal.plusSeconds(diffSeg);
			
		}else{
			int diffSeg;
			diffSeg = dateLocal.getSecondOfDay() - dateServidor.getHourOfDay();
			dateLocal.minusSeconds(diffSeg);
		}
		this.setHoraLocal(dateToString(dateLocal));
		System.out.println("Hora Ajustada :" + dateLocal);
	}

	private Date stringToDate(String dateString){
		SimpleDateFormat formato = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		Date date = null;
		try {
			date = formato.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	private String dateToString(DateTime date){
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    String dateString = formato.format(date.toDate());
		return dateString;
	}
	public long getDeriva() {
		return deriva;
	}
	public void setDeriva(long deriva) {
		this.deriva = deriva;
	}

}

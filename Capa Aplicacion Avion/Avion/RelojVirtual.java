package Avion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;

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
	public String horaMasDeriva(){
		DateTime dateTime = new DateTime(stringToDate(this.getHoraLocal()));
		dateTime.plusMillis((int)this.getDeriva());
		return RelojVirtual.dateToString(dateTime);
	}
	public void actualizarHoraLocal(String relojServidor){
		System.out.println("");
		DateTime dateServidor = new DateTime(RelojVirtual.stringToDate(relojServidor));
		DateTime dateLocal = new DateTime(RelojVirtual.stringToDate(this.getHoraLocal()));
		System.out.println("");
		System.out.println("Hora servidor: " + dateServidor);
		System.out.println("");
		System.out.println("Hora local:" + dateLocal);
		System.out.println("");

		
		//
		int diffHora;
		if (dateServidor.getHourOfDay()>dateLocal.getHourOfDay()){
			diffHora = dateServidor.getHourOfDay() - dateLocal.getHourOfDay();
			dateLocal=dateLocal.plusHours(diffHora);
		}else{

			diffHora = dateLocal.getHourOfDay()- dateServidor.getHourOfDay();
			dateLocal.minusHours(diffHora);
			dateLocal=dateLocal.minusHours(diffHora);
		}
		System.out.println("");
		System.out.println("La diferencia en horas es:" + diffHora);
		int diffMin;
		if (dateServidor.getMinuteOfDay()>dateLocal.getMinuteOfDay()){
			diffMin = dateServidor.getMinuteOfDay()%60 - dateLocal.getMinuteOfDay()%60;
			dateLocal.plusMinutes(diffMin);
			dateLocal=dateLocal.plusMinutes(diffMin);
			
		}else{
			diffMin = dateLocal.getMinuteOfDay()%60- dateServidor.getMinuteOfDay()%60;
			dateLocal.minusMinutes(diffMin);
			dateLocal=dateLocal.minusMinutes(diffMin);
		}
		System.out.println("");
		System.out.println("La diferencia en minutos es:" + diffMin);
		int diffSeg;
		if (dateServidor.getSecondOfDay()>dateLocal.getSecondOfDay()){
			diffSeg = dateServidor.getSecondOfDay()%60 - dateLocal.getSecondOfDay()%60;
			dateLocal.plusSeconds(diffSeg);
			dateLocal=dateLocal.plusSeconds(diffSeg);
			
		}else{
			diffSeg = dateLocal.getSecondOfDay() - dateServidor.getSecondOfDay();
			dateLocal.minusSeconds(diffSeg);
			dateLocal=dateLocal.minusSeconds(diffSeg);
		}
		System.out.println("");
		System.out.println("La diferencia en segundos es:" + diffSeg);
		this.setHoraLocal(dateToString(dateLocal));
		System.out.println("");
		System.out.println("Hora Ajustada :" + dateLocal);
	}

	public static Date stringToDate(String dateString){
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
	public static String dateToString(DateTime date){
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

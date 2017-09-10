import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Interval;


public class PruebaFecha {

	public static void main(String[] args) throws ParseException {
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date d = new Date();
		    String fecha = formato.format(d);
		    System.out.println("Fecha en string : " + fecha);
		    
		//  try {
		 //  	Date fechaDate = formato.parse(fecha);
			//	DateTime date = new DateTime(fechaDate);
			//	System.out.println("fecha en date:"+ date);
				//System.out.println("Fecha en string:" + formato.format(date));
		//	} catch (ParseException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
	//		}
			DateTime d1 = new DateTime();
			
            try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            DateTime d2 = new DateTime();
		    Interval interval = new Interval(d1,d2);
		    Duration duration = interval.toDuration();
		    System.out.println(duration.getMillis());
		   System.out.println(duration.getMillis()%1000);
		 //  float mili =  (float)Math.pow(10,-3)*(duration.getMillis()%1000);
		 //  float segYMili = mili + duration.getStandardSeconds();
		   String result = "2017-09-05 "+""+duration.getStandardHours()+":"
				   +duration.getStandardMinutes()+":00.123";
		   System.out.println(result);
		   System.out.println(formato.parse(result));
		   StringTokenizer tokens = new StringTokenizer(result,":");
		   System.out.println(tokens.nextToken());
		   System.out.println(tokens.nextToken());
		   System.out.println(tokens.nextToken());
		   	long ms = duration.getMillis();
		   	int mili = (int) (ms % 1000); ms -= mili; ms /= 1000;
		    int segs = (int) (ms % 60); ms -= segs; ms /= 60;
		    int mins = (int) (ms % 60); ms -= mins; ms /= 60;
		    int horas = (int) ms;
		    DateTime date12 = new DateTime(2017,9,5,horas,mins,segs,mili); 
		    System.out.println(date12);
//		    try {
//				Runtime.getRuntime().exec("netstat");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} //para la hora
//		    Process process=null;
//			try {
//				process = Runtime.getRuntime().exec("time 10:50:00 AM");
//				process.destroy();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    InputStream inputstream = process.getInputStream();
//		    BufferedInputStream bufferedinputstream = new BufferedInputStream(inputstream);
//		    System.out.println(bufferedinputstream);
		 //   System.out.println(formato.parse("2017-09-05 "+horas +":"+mins+":"+ segs+":"+ mili));
		 //   System.out.println(formato.format(date12.toDate()));
		 //   ProcessBuilder builder = new ProcessBuilder(new String[] { "cmd.exe", "/C", "time 05:30:00 PM"});

	}

}

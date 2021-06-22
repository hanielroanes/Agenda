package commons;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	public static Timestamp transformarDateEmTimeStampSQL(Date date) {
		return new Timestamp(date.getTime()); 
		
	}
	
	public static LocalDateTime transformarDateEmLocalDateTime(Date date) {
		return date.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
	
	public static Date transformarStringEmDate(String data) {
		Date date = new Date();
		try {
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			date = parser.parse(data);
		} catch (ParseException e) {
			System.out.println("ERRO AO TRANSFORMAR STRING EM DATE: " + e);
		}
		return date;
	}
}

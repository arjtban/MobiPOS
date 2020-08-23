package reportsMobi;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DateTimeClass {
	
	public String currentdate() {
		DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime today=LocalDateTime.now();
		return dtf1.format(today);
		//System.out.println(dtf1.format(today));
		
	}

}

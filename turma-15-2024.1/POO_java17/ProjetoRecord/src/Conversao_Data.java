import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Conversao_Data {
	public static void conversao() throws ParseException{
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data2 = sdf.parse("02/08/1970");
		System.out.println(data2);
		System.out.println(sdf.format(data2));
		
		System.out.println("Data formatada: "+sdf.format(data));

		//Converte Objetos
		 System.out.println("Data convertida: "+sdf.parse("15/08/1985"));
	}
} 

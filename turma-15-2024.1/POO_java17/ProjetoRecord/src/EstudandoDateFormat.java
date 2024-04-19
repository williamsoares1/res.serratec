import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class EstudandoDateFormat {
	
	public static void formatarDatas() { 
		Calendar c = Calendar.getInstance();
		c.set(2022, Calendar.APRIL, 14);
		
		Date data = c.getTime();
		System.out.println("Data atual sem formatação: "+data);
	
		//Formata a data
		// Estilos:
		// 0 - quinta-feira, 14 de abril de 2022 	- DateFormat.FULL
		// 1 - 14 de abril de 2022					- DateFormat.LONG
		// 2 - 14 de abr. de 2022					- DateFormat.MEDIUM / DateFormat.DEFAULT
		// 3 - 14/04/2022							- DateFormat.SHORT
		DateFormat formataData = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Data atual com formatação: "+ formataData.format(data));

		//Formata Hora
		DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: "+hora.format(data));
	
		//Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data));
	}
}

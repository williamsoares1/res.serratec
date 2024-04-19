import java.util.Calendar;

public class Metodos_Calendar {

	public static void TestaCalendar() {
		Calendar c = Calendar.getInstance();
		/*
		c.set(Calendar.YEAR, 2023);
		c.set(Calendar.MONTH, Calendar.APRIL +1);
		c.set(Calendar.DAY_OF_MONTH, 13);
		*/
		
		System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("Mês: "+c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
	}
}

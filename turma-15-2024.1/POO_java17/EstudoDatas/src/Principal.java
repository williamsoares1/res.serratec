import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;


public class Principal {
	public static void main(String[] args) {
		//ex_Date();
		
		//ex_Calendar();
		
		//ex_LocalDate();
		//exercicio_LocalDate();
		
		//ex_Localtime();
		ex_LocalDateTime();
	}
	
	public static void ex_Date() {
		Date dataDeHoje = new Date();
		
		System.out.println("Data de Hoje: " + dataDeHoje);
		System.out.println("Milisegundos desde 1 janeiro de 1970: " + dataDeHoje.getTime());
		System.out.println("Dia de hoje: " + dataDeHoje.getDate());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String dataFormatada = sdf.format(dataDeHoje);
		System.out.println("Data formatada: " + dataFormatada);
		
		try {
			Date data = sdf.parse("fghfhfhfhf");
			System.out.println(data.getDate());
		} catch (ParseException e) {
			System.out.println("Data inválida");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exceção");
		}
	}
	
	public static void ex_Calendar() {
		Calendar hoje = Calendar.getInstance();
		//GregorianCalendar hoje = new GregorianCalendar();
		System.out.println(hoje);
		
		int ano = hoje.get(Calendar.YEAR);
		int mes = hoje.get(Calendar.MONTH)+1;
		int dia = hoje.get(Calendar.DAY_OF_MONTH);
		int hora = hoje.get(Calendar.HOUR_OF_DAY);
		int minutos = hoje.get(Calendar.MINUTE);
		int segundos = hoje.get(Calendar.SECOND);
		
		System.out.println(dia + "/" + mes + "/" + ano);
		System.out.println(hora);
		
		System.out.printf("Hoje é: %02d/%02d/%d", dia, mes, ano);
		System.out.printf("\nHora: %d:%d:%02d", hora, minutos, segundos);
	}
	
	public static void ex_LocalDate() {
		LocalDate hoje = LocalDate.now();
		
		System.out.println(hoje);
		
		System.out.println("Uma data: " + LocalDate.of(2020, 8, 10));
		System.out.println("Outra data: " + LocalDate.parse("2023-05-01"));
		System.out.println("30 dias a mais: " + hoje.plusDays(32)); // Adiciona 30 dias
		System.out.println("8 dias atrás: " + hoje.minusDays(8));
		System.out.println("2 meses atrás: " + hoje.minus(2, ChronoUnit.MONTHS));
		System.out.println(hoje.getDayOfWeek() + " " + hoje.getDayOfMonth() + " " + hoje.getDayOfYear());
		System.out.println("Ano bissexto: " + hoje.isLeapYear());
		
		Period periodo = Period.between(hoje, LocalDate.of(2025, 5, 31));
		System.out.println("Intervalo é: " + periodo.getYears() + " ano(s), " + periodo.getMonths() + " mes(es) e " + periodo.getDays() + " dia(s)."); 
	}
	
	public static void exercicio_LocalDate() {
		LocalDate ld = LocalDate.now();
		
		System.out.println(ld);
		System.out.println("Dia da semana: " + ld.getDayOfWeek().name());
		
		switch (ld.getDayOfWeek().getValue()) { 
			case 1: System.out.println("Segunda-feira"); break; 
			case 2: System.out.println("Terça-feira"); break;
			case 3: System.out.println("Quarta-feira"); break;
			case 4: System.out.println("Quinta-feira"); break;
			case 5: System.out.println("Sexta-feira"); break;
			case 6: System.out.println("Sábado"); break;
			case 7: System.out.println("Domingo"); break;		
		}
		
		
		System.out.println("Dia da semana: " + ld.getDayOfWeek().getValue());
		System.out.println("Mês: " + ld.getMonthValue());
		System.out.println("Ano: " + ld.getYear());
		
		LocalDate aniversario = LocalDate.of(1976, 1, 23);
		Period pd = Period.between(aniversario, ld);		
		System.out.println("Número de anos vivo: " + pd.getYears());		
	}
	
	public static void ex_Localtime() {
		LocalTime hora = LocalTime.now();
		System.out.println(hora);
		
		System.out.println(LocalTime.of(20, 10));
		System.out.println(LocalTime.parse("20:50"));
		System.out.println("Hora Atual + 60 min: " + hora.plusMinutes(60));
		System.out.println("Hora Atual - 10 min: " + hora.minusMinutes(10));
	}
	
	public static void ex_LocalDateTime() {
		LocalDateTime dataHora = LocalDateTime.now();
		System.out.println(dataHora);
		System.out.println(dataHora.plusDays(10));
		System.out.println(LocalDateTime.of(2023, 4, 12, 21, 50, 30));
		
		ZoneId fuso = ZoneId.systemDefault();
		System.out.println(fuso);
		
		fuso = ZoneId.of("America/Sao_Paulo");
		System.out.println(fuso);
		
		Set<String> fusos = ZoneId.getAvailableZoneIds();
		
		for (String f : fusos) {
			System.out.println(f);
		}
	}
}

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DataSimples {
	public static Scanner input = new Scanner(System.in);
	
	public static void formatarData() {
		System.out.println("Informe a data: (dd/mm/yyyy hh:mm)");
		String sData = input.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			Date data = sdf.parse(sData);
			System.out.println(sdf.format(data));
		} catch (Exception e) {
			System.out.println("Data inválida");
		}
	}
	
	public static Date formatData(String sData, String sHora) {
		String dataHora = sData + " " + sHora;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			Date data = sdf.parse(dataHora);
			return data;
		} catch (Exception e) {
			System.out.println("Data inválida");
			return null;
		}
	}
}

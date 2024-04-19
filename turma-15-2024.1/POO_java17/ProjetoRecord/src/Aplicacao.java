import java.util.Scanner;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class Aplicacao {
	public static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) throws ParseException {
		
		System.out.println("Informe a data de nascimento: (dd/mm/yyyy)");
		String sData = input.next();		
		
		String sDia = sData.substring(0, 2);
		String sMes = sData.substring(3, 5);
		String sAno = sData.substring(6, 10);
		
		System.out.println(sDia+"/"+sMes+"/"+sAno);
		
		int iDia = Integer.parseInt(sDia);
		int iMes = Integer.parseInt(sMes);
		int iAno = Integer.parseInt(sAno);
		
		LocalDate dtNasc = LocalDate.of(iAno, iMes, iDia);
		
		Pessoa pessoa = new Pessoa(
				"Ricardo", 
				"08369535763", 
				"11471239-1", 
				dtNasc, 
				'M');
		
		/*
		System.out.printf("Nome: %s%n", pessoa.nome());
		System.out.printf("CPF: %s%n", pessoa.cpf());
		System.out.printf("RG: %s%n", pessoa.rg());
		System.out.printf("Dt.Nasc.: %s%n", pessoa.dtnascimento());
		System.out.printf("Sexo: %s%n", pessoa.sexo());
		*/
		/*
		pessoa.imprimirDadosPessoa();
		*/
		
		System.out.println("================================");
		EstudandoDateFormat.formatarDatas();		
		System.out.println("================================");		
		Metodos_Calendar.TestaCalendar();		
		System.out.println("================================");
		Classe_Date.data();
		System.out.println("================================");
		Conversao_Data.conversao(); 
	
		System.out.println("================================");
		DataSimples.formatarData();
		
	
		Date data;
		
		do {
			System.out.println("Informe a data: (dd/mm/yyyy)");
			String sData2 = input.nextLine();
			
			System.out.println("Informe a hora: (hh:mm)");
			String sHora = input.nextLine();
			
			data = DataSimples.formatData(sData2, sHora);
			
		} while (data==null);
		
		
		Classe_Date dt = new Classe_Date();
		
		dt.data();
	}
}

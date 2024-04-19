import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record Pessoa(
		String nome,
		String cpf,
		String rg,
		LocalDate dtnascimento,
		char sexo) {
				
	void imprimirDadosPessoa() {
		DateTimeFormatter dataf = DateTimeFormatter.ofPattern("dd/MM/yyyy");    
		String dataNasc = dtnascimento.format(dataf);
		
		System.out.printf("Nome: %s%n", nome());
		System.out.printf("CPF: %s%n", cpf());
		System.out.printf("RG: %s%n", rg());
		System.out.printf("Dt.Nasc.: %s%n", dataNasc);
		System.out.printf("Sexo: %s%n", sexo());
	}
}

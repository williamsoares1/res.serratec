package enum_aula;

public class Pessoa {
	enum EstadoCivil {
		CASADO('C'), SOLTEIRO('S'), VIUVO('V'), DIVORCIADO('D');
		
		@SuppressWarnings("unused")
		private char valor;
		
		EstadoCivil(char valor) {
			this.valor = valor;
		}
	}
	
	private String nome;
	private String email;
	private Setor setor;	
	private EstadoCivil estadoCivil;
		
	public Pessoa(String nome, String email, Setor setor, EstadoCivil estadoCivil) {
		super();
		this.nome = nome;
		this.email = email;
		this.setor = setor;
		this.estadoCivil = estadoCivil;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public Setor getSetor() {
		return setor;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", email=" + email + ", setor=" + setor + ", estadoCivil=" + estadoCivil + "]";
	}	
}

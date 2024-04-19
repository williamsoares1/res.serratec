package enum_aula;

public enum Setor {
	RH(10), COMPRAS(20), CPD(35), FINANCEIRO(42), DIRETORIA(50), DP(62), CONTABILIDADE(70);
	
	private int sala;
	
	private Setor(int sala) {
		this.sala = sala;
	}

	public int getSala() {
		return sala;
	}
	
	
}

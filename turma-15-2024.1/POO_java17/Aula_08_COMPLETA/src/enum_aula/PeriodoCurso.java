package enum_aula;

public enum PeriodoCurso {
	INTEGRAL("terça e quinta", 40, 2400.0), 
	NOTURNO("sexta", 20, 1000.0), 
	MANHA("segunda e quarta", 30, 2000.0);
	
	private final String diaSemana;
	private final int cargaHoraria;
	private final double valor;
	
	private PeriodoCurso(String diaSemana, int cargaHoraria, double valor) {
		this.diaSemana = diaSemana;
		this.cargaHoraria = cargaHoraria;
		this.valor = valor;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public double getValor() {
		return valor;
	}
	
}

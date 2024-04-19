package classes;
             
public class Produto {
	private String descricao = "Minha descri��o";
	private int quantidade;
	private int codigo;
	private static int totalProdutos = 0;
	
	public Produto() {
		System.out.println("Constru��o sem par�metros.");
		Produto.totalProdutos++;
	}
	
	public Produto(String descricao, int quantidade, int codigo) {
		this();
		System.out.println("Constru��o com par�metros.");
		if (!descricao.isEmpty()) {
			this.descricao = descricao;
		};
		this.quantidade = quantidade;
		this.codigo = codigo;
	}
	
	public Produto(String descricao) {
		this.descricao = descricao;
	}
	
	public Produto(int quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * Aqui voc� calcula A
	 */
	public void calcular() {
		
	}
	
	/**
	 * Aqui voc� calcula B
	 * @param abc - Informe o n�mero que deseja calcular
	 * @return Retorna o resultado do c�lculo
	 */
	public int calcular(int abc) {
		return 0;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public static int getTotalProdutos() {
		return totalProdutos;
	}



	
	
}

package br.com.serratec.files;

public class Principal {
	
	public static void main(String[] args) {
		ArquivoTxt myFile = new ArquivoTxt("meu_arquivo.txt");
		
		myFile.criarArquivo();
		
		String dados = "Uma linha\nDuas linhas\nTrês linhas\n";
		
		myFile.escreverArquivo(dados);
		myFile.escreverArquivo("Local: localhost");
		myFile.escreverArquivo("Porta: 5432");
		myFile.escreverArquivo("User: ");
		
		String arquivo = myFile.lerArquivo();
		
		System.out.println(arquivo);
	}
}

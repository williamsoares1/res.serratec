package arquivo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LerArquivoDelimiter {
	public static void main(String[] args) {
		//ExemploFile();
		//contarCaracteres();
		//escreverBinario();
		lerBinario2();
	}
	
	public static void lerArquivo() {
		String nome[] = new String[4];
		String idade[] = new String[4]; 
		String data[] = new String[4];
		int i = 0;
		
		try {
			Scanner sc = new Scanner(new File("/Temp/teste.csv"));
			sc.useDelimiter(";");
			
			while (sc.hasNext()) {
				nome[i] = sc.next();
				idade[i] = sc.next();
				data[i] = sc.next();
				
				i++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
			e.printStackTrace();
		}
		
		System.out.println("1-----------------");
		System.out.println(nome[0]);
		System.out.println(idade[0]);
		System.out.println(data[0]);
		System.out.println("2-----------------");
		System.out.println(nome[1]);
		System.out.println(idade[1]);
		System.out.println(data[1]);
		System.out.println("3-----------------");
		System.out.println(nome[2]);
		System.out.println(idade[2]);
		System.out.println(data[2]);
		System.out.println("4-----------------");
		System.out.println(nome[3]);
		System.out.println(idade[3]);
		System.out.println(data[3]);
		System.out.println("-----------------fim");
		

		for (int j=0; j < nome.length; j++) {
			System.out.println("Nome: " + nome[j] +" - Idade: " + idade[j] + " - data: " + data[j]);
		}

	}
	
	public static void ExemploFile() {
		@SuppressWarnings("resource")
		Scanner ler = new Scanner(System.in);
		
		System.out.println("Informe o nome de um arquivo ou diretório: ");
		String nome = ler.nextLine();
		
		File file = new File(nome);
		
		if (file.exists()) {
			if (file.isFile()) {
				System.out.printf("\nArquivo (%s) existe - tamanho: %d bytes\n",
						file.getName(), file.length());				
			} else {
				System.out.println("\nConteúdo do diretório:\n");
				String diretorio[] = file.list();
				
				for (String item: diretorio) {
					System.out.printf("%s\n",item);
				}
			}
		} else {
			System.out.printf("Arquivo ou diretório informado não existe!\n");
		}		
	}

	public static void contarCaracteres() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/temp/temp/FIS0012310.TXT"));  
			int qtCaracteres = 0;
			
			while (br.ready()) {
				String linha = br.readLine();
				qtCaracteres += linha.length();
				System.out.println(linha.length());
			}
			
			System.out.println("Total de caracteres = " + qtCaracteres);
			
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não existe.");
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ocorreu um erro no arquivo.");
			//e.printStackTrace();
		}
	}

	public static void escreverBinario() {
		try {
			FileOutputStream arq = new FileOutputStream("/temp/arquivo.dat");
			DataOutputStream gravarArq = new DataOutputStream(arq);
			
			gravarArq.writeChars("Bom dia, Ricardo");
			gravarArq.close();
			
		} catch (IOException e) {
			System.out.println("Erro ao acessar o arquivo");
		}
	}

	public static void lerBinario2() {
		try {
			FileInputStream arq = new FileInputStream("/temp/arquivo.dat");
			DataInputStream lerArq = new DataInputStream(arq);
			
			String leitura = lerArq.readLine();
			System.out.println(leitura);
			
			lerArq.close();
			
		} catch (IOException e) {
			System.out.println("Erro ao acessar o arquivo");
			e.printStackTrace();
		}
	}
}
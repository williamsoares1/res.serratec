package br.com.serratec.interfaces;

import br.com.serratec.aula07.Constante;
import br.com.serratec.classes.Cliente;
import br.com.serratec.classes.Fornecedor;
//import br.com.serratec.classes.Pedido;
//import br.com.serratec.classes.PedItem;
//import br.com.serratec.classes.Produto;
import br.com.serratec.classes.dao.ClienteDAO;
import br.com.serratec.classes.dao.CreateDAO;
import br.com.serratec.classes.dao.FornecedorDAO;
import br.com.serratec.conexao.Conexao;
import br.com.serratec.conexao.DadosConexao;
import br.com.serratec.files.ArquivoTxt;
//import java.util.Date;
import java.util.Scanner;

public class Principal {
	public static Scanner input = new Scanner(System.in);
	public static final String BD = "java";
	public static final String SCHEMA = "sistema";
	public static final String PATH = "C:\\temp\\";
	public static final String SFILE = "DadosConexao.ini";
	
	public static void main(String[] args) {
		//Pedido pedido = new Pedido();
		ArquivoTxt conexaoIni = new ArquivoTxt(PATH+SFILE);
		DadosConexao dadosCon = new DadosConexao();
		boolean abrirSistema = false;
		
		if (conexaoIni.criarArquivo()) {
			if (conexaoIni.alimentaDadosConexao()) {
				dadosCon = conexaoIni.getData();
				abrirSistema = true;
			} else {
				conexaoIni.apagarArquivo();
				System.out.println("Arquivo de configuração de conexão:\n");
				System.out.println("Local: ");
				String local = input.nextLine();
				System.out.println("Porta: ");
				String porta = input.nextLine();
				System.out.println("Usuário: ");
				String usuario = input.nextLine();
				System.out.println("Senha: ");
				String senha = input.nextLine();
				System.out.println("Database: ");
				String banco = input.nextLine();
				
				if (conexaoIni.criarArquivo()) {
					conexaoIni.escreverArquivo("bd=PostgreSql");
					conexaoIni.escreverArquivo("local="+local);
					conexaoIni.escreverArquivo("porta="+porta);
					conexaoIni.escreverArquivo("usuario="+usuario);
					conexaoIni.escreverArquivo("senha="+senha);
					conexaoIni.escreverArquivo("banco="+banco);
					
					if (conexaoIni.alimentaDadosConexao()) {
						dadosCon = conexaoIni.getData();
						abrirSistema = true;
					} else System.out.println("Não foi possível efetuar a configuração.\nVerifique");	
				}
			}
		} else
			System.out.println("Houve um problema na criação do arquivo de configuração.");
		
		if (abrirSistema) {
			if (CreateDAO.createBD(BD, SCHEMA, dadosCon)) {
				Conexao con = new Conexao(dadosCon); 
				con.conect();
				menuPrincipal(con);
				/*
				//ClienteDAO clienteDao = new ClienteDAO(con, SCHEMA);
				PedItem p = new PedItem();
				
				pedido.setIdpedido(1);
				pedido.setDataPedido(new Date());
				pedido.setNumero("0001");
				
				double valorTotal = 0;
				
				p.setDescricao("Chinelo");
				p.setIdProduto(1);
				p.setVlCusto(15.00);
				p.setVlPreco(35.90);
				p.setQuantidade(10);
				
				valorTotal += p.getQuantidade() * p.getVlPreco();
				
				pedido.adicionarProduto(p);
				
				p.setDescricao("Tênis");
				p.setIdProduto(2);
				p.setVlCusto(150.00);
				p.setVlPreco(350.90);
				p.setQuantidade(3);
				
				valorTotal += p.getQuantidade() * p.getVlPreco();
				
				pedido.adicionarProduto(p);
				
				pedido.setValorPedido(valorTotal);
				
				pedido.imprimirItensPedido();
				System.out.printf("Valor total Pedido: R$ %,2.2f%n", pedido.getValorPedido());
				System.out.printf("Data pedido: %s", pedido.getStringDataPedido());
				*/
			} else {
				System.err.println("Houve um problema na criação do banco de dados.");
			}	
		}
		
	}
	
	public static void menuPrincipal(Conexao con) {
		int opcao;
		
		do {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("---------------------");
			System.out.println("0- Sair");
			System.out.println("1- Cliente");
			System.out.println("2- Fornecedor");
			System.out.println("3- Categoria");
			System.out.println("4- SubCategoria");
			System.out.println("5- Produto");			
			
			opcao = informeOpcao("Informe uma opção: ");
			
			switch(opcao) {
			case 0: System.out.println("Sistema encerrado."); break;
			case 1: menuCliente(con); break;	
			case 2: menuFornecedor(con); break;
			case 3: //menuCategoria(con); break;
			case 4: //menuSubCategoria(con); break;
			case 5: //menuProduto(con); break;
			default: System.out.println("Opção inválida.");
			}		
			
		} while (opcao!=0);	
		
	}
	
	public static int informeOpcao(String msg) {
		System.out.print("\n"+ msg);
		String resposta = input.nextLine();
		int opcao;
		
		try {
			opcao = Integer.parseInt(resposta);
		} catch (Exception e) {					
			opcao = 0;
		}
		
		return opcao;
	}
	
	public static void menuCRUD( ) {
		System.out.println("1- Incluir");
		System.out.println("2- Alterar");
		System.out.println("3- Excluir");
		System.out.println("4- Localizar");
		System.out.println("5- Listar");
		System.out.println("6- Voltar");
	}
	
	public static void menuFornecedor(Conexao con) {
		int opcao;
		
		do {
			menuCRUD();
			opcao = informeOpcao("Informe uma opção: ");
			
			switch(opcao) {			
			case 1: incluirFornecedor(con); break;
			case 2: alterarFornecedor(con); break;
			case 3: excluirFornecedor(con); break;
			case 4: localizarFornecedor(con); break;
			case 5: listarFornecedor(con); break;
			case 6: break;
			default: System.out.println("Opção inválida.");
			}	
		} while (opcao!=6);
	}
	
	public static void incluirFornecedor(Conexao con) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(con, SCHEMA);		
		Fornecedor fornecedor = solicitarDadosFornecedor();		
		fornecedorDAO.incluirFornecedor(fornecedor);
	}
	
	public static void alterarFornecedor(Conexao con) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 
		
		Fornecedor fornecedor = fornecedorDAO.localizarfornecedor(null, codigo);
				
		if (fornecedor!=null) {
			fornecedorDAO.alterarFornecedor(fornecedor);
		}	
	}
	
	public static void excluirFornecedor(Conexao con) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 
		
		Fornecedor fornecedor = fornecedorDAO.localizarfornecedor(null, codigo);
		
		if (fornecedor!=null) {
			fornecedorDAO.apagarfornecedor(fornecedor.getIdfornecedor());
		}
	}
	
	public static void localizarFornecedor(Conexao con) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 		
		Fornecedor fornecedor = fornecedorDAO.localizarfornecedor(null, codigo);
		
		if (fornecedor != null) {
			System.out.println("Localização do cliente");
			System.out.println(Constante.LINHA_FINA);
			System.out.printf("Nome: %s", fornecedor.getRazaoSocial());
			System.out.printf("CNPJ: %s", fornecedor.getCnpj());
		}
	}
	
	public static void listarFornecedor(Conexao con) {
		FornecedorDAO fornecedorDAO = new FornecedorDAO(con, SCHEMA);		
		fornecedorDAO.listarfornecedors();
	}
	
	public static void menuCliente(Conexao con) {
		int opcao;
		
		do {
			menuCRUD();
			opcao = informeOpcao("Informe uma opção: ");
			
			switch(opcao) {			
			case 1: incluirCliente(con); break;
			case 2: alterarCliente(con); break;
			case 3: excluirCliente(con); break;
			case 4: localizarCliente(con); break;
			case 5: listarCliente(con); break;
			case 6: break;
			default: System.out.println("Opção inválida.");
			}	
		} while (opcao!=6);
	}
	
	public static void excluirCliente(Conexao con) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 		
		Cliente cliente = clienteDAO.localizarCliente(null, codigo);
		
		if (cliente != null) {
			clienteDAO.apagarCliente(cliente.getIdcliente());
		}
	}
	
	public static void localizarCliente(Conexao con) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 		
		Cliente cliente = clienteDAO.localizarCliente(null, codigo);
		
		if (cliente != null) {
			System.out.println("Localização do cliente");
			System.out.println(Constante.LINHA_FINA);
			System.out.printf("Nome: %s", cliente.getNome());
			System.out.printf("Endereço: %s", cliente.getEndereco());
		}
	}
	
	public static void alterarCliente(Conexao con) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		
		int codigo = informeOpcao("\nInforme o código: "); 
		Cliente cliente = clienteDAO.localizarCliente(null, codigo);
				
		if (cliente!=null) {
			clienteDAO.alterarCliente(cliente);
		}		
	}
	
	public static void listarCliente(Conexao con) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		clienteDAO.listarClientes();
	}
	
	public static void incluirCliente(Conexao con) {
		ClienteDAO clienteDAO = new ClienteDAO(con, SCHEMA);
		Cliente cliente = solicitarDadosCliente();
		clienteDAO.incluirCliente(cliente);
	}
	
	public static Fornecedor solicitarDadosFornecedor() {
		Fornecedor fornecedor = new Fornecedor();
		
		System.out.println("\nDados do fornecedor");
		System.out.println(Constante.LINHA_FINA);
		System.out.println("Informe a Razão Social: ");
		String razao = input.nextLine();
		
		System.out.println("Informe o Nome Fantasia: ");
		String nome = input.nextLine();
		
		System.out.println("Informe o CNPJ: ");
		String cnpj = input.nextLine();
		
		System.out.println("Informe o endereço: ");
		String endereco = input.nextLine();
		
		fornecedor.setRazaoSocial(razao);
		fornecedor.setNmFantasia(nome);
		fornecedor.setCnpj(cnpj);
		fornecedor.setEndereco(endereco);
		
		return fornecedor;
	}
	
	public static Cliente solicitarDadosCliente() {
		Cliente cliente = new Cliente();
		
		System.out.println("\nDados do cliente");
		System.out.println(Constante.LINHA_FINA);
		System.out.println("Informe o nome: ");
		String nome = input.nextLine();
		
		System.out.println("Informe o CPF: ");
		String cpf = input.nextLine();
		
		System.out.println("Informe o RG: ");
		String rg = input.nextLine();
		
		System.out.println("Informe o sexo: ");
		String sexo = input.nextLine();
		
		System.out.println("Informe o endereço: ");
		String endereco = input.nextLine();
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setSexo(sexo);
		cliente.setEndereco(endereco);
		
		return cliente;
	}
	
	public static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }
	
	public static Cliente localizarClientePor(Conexao con) {
		ClienteDAO clienteDao = new ClienteDAO(con, SCHEMA);
		Cliente cliente = null;
		int opcao;
		
		do {
			opcao = informeOpcao("Escolha como localizar");
		
			System.out.println("1- Nome");
			System.out.println("2- Código");
			System.out.println("3- Voltar");
				
			switch (opcao) {
			case 1: 
				System.out.println("Informe o nome: ");
				String nome = input.nextLine();
				cliente = clienteDao.localizarCliente(nome, 0);
				if (cliente==null) {
					System.out.println("Cliente não encontrado");
				} else opcao = 3;
				break;
			case 2: 
				System.out.println("Informe o código: ");
				int codigo = informeOpcao("");
				cliente = clienteDao.localizarCliente(null, codigo);
				if (cliente==null) {
					System.out.println("Cliente não encontrado");
				} else opcao = 3;
				break;
			default: System.out.println("Código inválido");
			}
		} while (opcao!=3);
		
		return cliente;
	}
}

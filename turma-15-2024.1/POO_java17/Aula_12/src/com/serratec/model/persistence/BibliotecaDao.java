package com.serratec.model.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.serratec.model.connection.Conexao;
import com.serratec.model.entity.Biblioteca;
import com.serratec.model.entity.Biblioteca.LivrosEmprestados;
import com.serratec.model.entity.Cliente;
import com.serratec.model.entity.Livro;

public class BibliotecaDao {
	private Conexao con;
	private String schema;
	
	public BibliotecaDao(Conexao con, String schema) {
		this.con = con;
		this.schema = schema;
	}
	
	private class LivroDao extends Dao<Livro, PesquisaLivro> {
		
		public LivroDao(Conexao con, String schema) {
			super(con, schema, prepararSqlInclusao(schema), prepararSqlAlteracao(schema),
					prepararSqlExclusao(schema));
		}

		@Override
		public int incluir(Livro livro) {
			ResultSet rs;
			
			try {						
				pInclusao.setInt(1, livro.getCodigo());
				
				int result = pInclusao.executeUpdate();
				
				rs = pInclusao.getGeneratedKeys();
				
//				if(rs.next()){
//					cliente.setIdClientebib(rs.getInt(1));
//					cliente.setNumero_socio("B-"+ cliente.getNome().substring(0,5) + "-" + rs.getInt(1));
//					
//					alterar(cliente);					
//				}
				
				rs.close();
				return result;
				
			} catch (SQLException e){
				System.err.println(e);
				e.printStackTrace();
			} catch (Exception e) {
				if (e.getLocalizedMessage().contains("is null")) {
					System.err.println("\nCliente nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
				} else {				
					System.err.println(e);
					e.printStackTrace();
				}
			}
			return 0;
	}

		@Override
		public int alterar(Livro objeto) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int excluir(Livro objeto) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public List<Livro> listar() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Livro pesquisar(String pesquisa, PesquisaLivro e) {
			// TODO Auto-generated method stub
			return null;
		}
		
		private static String prepararSqlAlteracao(String schema) {
			StringBuilder updateSql = new StringBuilder()
					.append("update " + schema + ".livros_cliente")
					.append(" set quantidade = ? ")
					.append(" where idclientbib = ?");
					
			return updateSql.toString();
		}
		private static String prepararSqlInclusao(String schema) {
			StringBuilder insertSql = new StringBuilder()
					.append("insert into "+ schema + ".livros_cliente")	
					.append(" (idclientebib, idlivro, quantidade)")
					.append(" values ")
					.append(" (?, ?, ?)");
			
			return insertSql.toString();
		}
		private static String prepararSqlExclusao(String schema) {
			StringBuilder deleteSql = new StringBuilder()
					.append("delete from "+ schema + ".livros_cliente")
					.append(" where idlivrocliente = ?");
			
			return deleteSql.toString();
		}

	}
	
	private class ClienteDao extends Dao<Biblioteca.ClienteBib, Pesquisa> {
		protected PreparedStatement pInclusaoLivrosEmp;
		protected PreparedStatement pAlteracaoLivrosEmp;
		protected PreparedStatement pExclusaoLivrosEmp;
				
		public ClienteDao(Conexao con, String schema) {
			super(con, schema, prepararSqlInclusao(schema), prepararSqlAlteracao(schema),
					prepararSqlExclusao(schema));	
			
			executarPreparedStatmentLivrosEmp(
					prepararSqlInclusaoLivrosEmp(schema), 
					prepararSqlAlteracaoLivrosEmp(schema),
					prepararSqlExclusaoLivrosEmp(schema));
		}
	
		@Override
		public int incluir(Biblioteca.ClienteBib cliente) {
			ResultSet rs;
			
			try {						
				pInclusao.setInt(1, cliente.getCodigo());
				
				int result = pInclusao.executeUpdate();
				
				rs = pInclusao.getGeneratedKeys();
				
				if(rs.next()){
					cliente.setIdClientebib(rs.getInt(1));
					cliente.setNumero_socio("B-"+ cliente.getNome().substring(0,5) + "-" + rs.getInt(1));
					
					alterar(cliente);					
				}
				
				rs.close();
				return result;
				
			} catch (SQLException e){
				System.err.println(e);
				e.printStackTrace();
			} catch (Exception e) {
				if (e.getLocalizedMessage().contains("is null")) {
					System.err.println("\nCliente nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
				} else {				
					System.err.println(e);
					e.printStackTrace();
				}
			}
			return 0;
		}

		@Override
		public int alterar(Biblioteca.ClienteBib cliente) {			
			try {
				pAlteracao.setString(1, cliente.getNumero_socio());
				pAlteracao.setInt(2, cliente.getIdClientebib());
				
				return pAlteracao.executeUpdate();
				
			} catch (Exception e) {
				if (e.getLocalizedMessage().contains("is null")) {
					System.err.println("\nCliente nao alterado.\nVerifique se foi chamado o conect:\n" + e);				
				} else {				
					System.err.println(e);
					e.printStackTrace();
				}
				return 0;
			}
		}

		@Override
		public int excluir(Biblioteca.ClienteBib cliente) {
			try {
				pExclusao.setInt(1, cliente.getCodigo());
				
				return pExclusao.executeUpdate();
			} catch  (Exception e) {
				if (e.getLocalizedMessage().contains("is null")) {
					System.err.println("\nCliente não excluído.\nVerifique se foi chamado o conect:\n" + e);				
				} else {				
					System.err.println(e);
					e.printStackTrace();
				}
				return 0;
			}
		}

		@Override
		public List<Biblioteca.ClienteBib> listar() {
			ResultSet tabela;		
			List<Biblioteca.ClienteBib> lista = new ArrayList<Biblioteca.ClienteBib>();
			StringBuilder listarSql = new StringBuilder() 
					.append("select cl.*, cb.idclientebib, cb.numero_socio")
					.append(" from " + getSchema() + ".clientesbib cb")
					.append(" left join " + getSchema() + ".clientes cl");
			String sql = listarSql.toString();
					
			tabela = getCon().query(sql);
			
			try {
				int index;
				
				while (tabela.next()) {
					Cliente cl = new Cliente();
										
					cl.setCodigo(tabela.getInt("idcliente"));
					cl.setCpf(tabela.getString("cpf"));
					cl.setDtNasc(tabela.getDate("dtnasc").toLocalDate());
					cl.setEndereco(tabela.getString("endereco"));
					cl.setSexo(tabela.getString("sexo").charAt(0));
					cl.setNome(tabela.getString("nome"));
					
					Biblioteca.ClienteBib clbib = (Biblioteca.ClienteBib) cl;
					
					lista.add(clbib);
					
					index = lista.indexOf(clbib);
					lista.get(index).setNumero_socio(tabela.getString("numero_socio"));
					lista.get(index).setIdClientebib(tabela.getInt("idclientebib"));
				}
				tabela.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lista;
		}

		@Override
		public Biblioteca.ClienteBib pesquisar(String pesquisa, Pesquisa e) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public int incluirLivroEmprestado(Biblioteca.ClienteBib cliente) {
			ResultSet rs;
			
			for (int i=0; i< cliente.getLivrosEmprestados().size(); i++) {
				try {	
					//(idclientebib, idlivro, quantidade)
					int codigo = cliente.getLivrosEmprestados().get(i).getCodigo();
					int idcliente = cliente.getCodigo();
					int quantEmprestimo = cliente.getLivrosEmprestados().get(i).getQuantEmprestimo();
					
					pInclusaoLivrosEmp.setInt(1, codigo);
					pInclusaoLivrosEmp.setInt(1, idcliente);
					pInclusaoLivrosEmp.setInt(1, quantEmprestimo);
					
					int result = pInclusaoLivrosEmp.executeUpdate();
					
					rs = pInclusaoLivrosEmp.getGeneratedKeys();
					
					if(rs.next()){
						cliente.getLivrosEmprestados().get(i).setIdlivroCliente(rs.getInt(1));											
					}
					
					rs.close();
					return result;
					
				} catch (SQLException e){
					System.err.println(e);
					e.printStackTrace();
				} catch (Exception e) {
					if (e.getLocalizedMessage().contains("is null")) {
						System.err.println("\nCliente nao incluido.\nVerifique se foi chamado o conect:\n" + e);				
					} else {				
						System.err.println(e);
						e.printStackTrace();
					}
				}
			}
			return 0;
		}
		
		private static String prepararSqlAlteracao(String schema) {
			StringBuilder updateSql = new StringBuilder()
					.append("update " + schema + ".clientebib")
					.append(" set numero_socio = ? ")
					.append(" where idclientbib = ?");
					
			return updateSql.toString();
		}
		private static String prepararSqlInclusao(String schema) {
			StringBuilder insertSql = new StringBuilder()
					.append("insert into "+ schema + ".clientebib")	
					.append(" (idcliente)")
					.append(" values ")
					.append(" (?, ?)");
			
			return insertSql.toString();
		}
		private static String prepararSqlExclusao(String schema) {
			StringBuilder deleteSql = new StringBuilder()
					.append("delete from "+ schema + ".clientebib")
					.append(" where idcliente = ?");
			
			return deleteSql.toString();
		}
		
		private static String prepararSqlAlteracaoLivrosEmp(String schema) {
			StringBuilder updateSql = new StringBuilder()
					.append("update " + schema + ".livros_cliente")
					.append(" set quantidade = ? ")
					.append(" where idclientbib = ?");
					
			return updateSql.toString();
		}
		private static String prepararSqlInclusaoLivrosEmp(String schema) {
			StringBuilder insertSql = new StringBuilder()
					.append("insert into "+ schema + ".livros_cliente")	
					.append(" (idclientebib, idlivro, quantidade)")
					.append(" values ")
					.append(" (?, ?, ?)");
			
			return insertSql.toString();
		}
		private static String prepararSqlExclusaoLivrosEmp(String schema) {
			StringBuilder deleteSql = new StringBuilder()
					.append("delete from "+ schema + ".livros_cliente")
					.append(" where idlivrocliente = ?");
			
			return deleteSql.toString();
		}

		private void executarPreparedStatmentLivrosEmp(String pSqlInclusao,
				String pSqlAlteracao, String pSqlExclusao) {	
			this.pInclusaoLivrosEmp = preparar(pSqlInclusao, Statement.RETURN_GENERATED_KEYS);
			this.pAlteracaoLivrosEmp = preparar(pSqlAlteracao);
			this.pExclusaoLivrosEmp = preparar(pSqlExclusao);
		}	
		
		private PreparedStatement preparar(String sql, int...i) {	
			try {
				if (i[0] == 1)
					return con.getC().prepareStatement(sql, i);
				else
					return con.getC().prepareStatement(sql);
			} catch (Exception e) {
				System.err.println(e);
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
	
}

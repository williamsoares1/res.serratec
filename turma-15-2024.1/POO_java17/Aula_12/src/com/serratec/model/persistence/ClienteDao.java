package com.serratec.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serratec.model.connection.Conexao;
import com.serratec.model.entity.Cliente;

public class ClienteDao extends Dao<Cliente, Pesquisa> {

	public ClienteDao(Conexao con, String schema) {		
		super(con, schema, prepararSqlInclusao(schema), prepararSqlAlteracao(schema),
				prepararSqlExclusao(schema));		
	}
	
	//------------------------------------------------



	@Override
	public int incluir(Cliente cliente) {
		ResultSet rs;
		
		try {		
			
			pInclusao.setString(1, cliente.getNome());
			pInclusao.setString(2, cliente.getCpf());
			pInclusao.setString(3, cliente.getEndereco());
			pInclusao.setDate(4, Date.valueOf(cliente.getDtNasc()));
			pInclusao.setString(5, String.valueOf(cliente.getSexo()));
			
			int result = pInclusao.executeUpdate();
			
			rs = pInclusao.getGeneratedKeys();
			if(rs.next()){
				cliente.setCodigo(rs.getInt(1));			
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
	public int alterar(Cliente cliente) {
		try {
			pAlteracao.setString(1, cliente.getNome());
			pAlteracao.setString(2, cliente.getCpf());
			pAlteracao.setString(3, cliente.getEndereco());
			pAlteracao.setDate(4, Date.valueOf(cliente.getDtNasc()));
			pAlteracao.setString(5, String.valueOf(cliente.getSexo()));
			pAlteracao.setInt(7, cliente.getCodigo());
			
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
	public int excluir(Cliente cliente) {
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
	public Cliente pesquisar(String pesquisa, Pesquisa tipoPesquisa) {
		ResultSet tabela;
		Cliente cl = null;
		String sql = "select * from " + getSchema() + ".cliente";
		
		switch (tipoPesquisa) {
		case CODIGO: 
			sql += " where idcliente = " + pesquisa;
			break;
		case NOME:
			sql += " where upper(nome) = " + pesquisa.toUpperCase() + " order by nome, idcliente";
			break;
		case CPF:
			sql += " where cpf = " + pesquisa;
			break;
		default: return null;
		}
		
		tabela = getCon().query(sql);
		
		try {
			if (tabela.next()) {
				cl = new Cliente();
				
				cl.setCodigo(tabela.getInt("idcliente"));
				cl.setCpf(tabela.getString("cpf"));
				cl.setDtNasc(tabela.getDate("dtnasc").toLocalDate());
				cl.setEndereco(tabela.getString("endereco"));
				cl.setSexo(tabela.getString("sexo").charAt(0));
				cl.setNome(tabela.getString("nome"));
			}
			tabela.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cl;
	}
	@Override
	public List<Cliente> listar() {
		ResultSet tabela;		
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "select * from " + getSchema() + ".cliente";
				
		tabela = getCon().query(sql);
		
		try {
			while (tabela.next()) {
				Cliente cl = new Cliente();
				
				cl.setCodigo(tabela.getInt("idcliente"));
				cl.setCpf(tabela.getString("cpf"));
				cl.setDtNasc(tabela.getDate("dtnasc").toLocalDate());
				cl.setEndereco(tabela.getString("endereco"));
				cl.setSexo(tabela.getString("sexo").charAt(0));
				cl.setNome(tabela.getString("nome"));
				
				lista.add(cl);
			}
			tabela.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	//------------------------------------------------

	private static String prepararSqlAlteracao(String schema) {
		StringBuilder updateSql = new StringBuilder()
				.append("update "+ schema + ".cliente")
				.append(" set nome = ?,")
				.append(" cpf = ?,")
				.append(" endereco = ?,")
				.append(" dtnasc = ?,")
				.append(" sexo = ?")
				.append(" where idcliente = ?");
				
		return updateSql.toString();
	}
	private static String prepararSqlInclusao(String schema) {
		StringBuilder insertSql = new StringBuilder()
				.append("insert into "+ schema + ".cliente")	
				.append(" (nome, cpf, endereco, dtnasc, sexo)")
				.append(" values ")
				.append(" (?, ?, ?, ?, ?)");
		
		return insertSql.toString();
	}
	private static String prepararSqlExclusao(String schema) {
		StringBuilder deleteSql = new StringBuilder()
				.append("delete from "+ schema + ".cliente")
				.append(" where idcliente = ?");
		
		return deleteSql.toString();
	}
}

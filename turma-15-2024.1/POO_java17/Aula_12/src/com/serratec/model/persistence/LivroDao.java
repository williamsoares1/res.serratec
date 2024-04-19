package com.serratec.model.persistence;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.serratec.model.connection.Conexao;
import com.serratec.model.entity.Cliente;
import com.serratec.model.entity.Livro;

public class LivroDao extends Dao<Livro, PesquisaLivro>{

	public LivroDao(Conexao con, String schema) {
		super(con, schema, prepararSqlInclusao(schema), prepararSqlAlteracao(schema),
				prepararSqlExclusao(schema));
	}

	@Override
	public int incluir(Livro livro) {
		ResultSet rs;
		
		try {		
			
			pInclusao.setString(1, livro.getTitulo());
			pInclusao.setString(2, livro.getIsbn());
			pInclusao.setString(3, livro.getAutor());
			pInclusao.setDate(4, Date.valueOf(livro.getEditora()));
			pInclusao.setString(5, String.valueOf(livro.getValor()));
			
			int result = pInclusao.executeUpdate();
			
			rs = pInclusao.getGeneratedKeys();
			if(rs.next()){
				livro.setCodigo(rs.getInt(1));			
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
	public int alterar(Livro livro) {
		try {
			pAlteracao.setString(1, livro.getTitulo());
			pAlteracao.setString(2, livro.getIsbn());
			pAlteracao.setString(3, livro.getAutor());
			pAlteracao.setString(4, livro.getEditora());
			pAlteracao.setDouble(5, livro.getValor());
			pAlteracao.setInt(7, livro.getCodigo());
			
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
	public int excluir(Livro livro) {
		try {
			pExclusao.setInt(1, livro.getCodigo());
			
			return pExclusao.executeUpdate();
		} catch  (Exception e) {
			if (e.getLocalizedMessage().contains("is null")) {
				System.err.println("\nLivro não excluído.\nVerifique se foi chamado o conect:\n" + e);				
			} else {				
				System.err.println(e);
				e.printStackTrace();
			}
			return 0;
		}
	}

	@Override
	public List<Livro> listar() {
		ResultSet tabela;		
		List<Livro> lista = new ArrayList<Livro>();
		String sql = "select * from " + getSchema() + ".livro";
				
		tabela = getCon().query(sql);
		
		try {
			while (tabela.next()) {
				Livro lv = new Livro();
				
				lv.setCodigo(tabela.getInt("idlivro"));
				lv.setAutor(tabela.getString("autor"));
				lv.setEditora(tabela.getString("editora"));
				lv.setIsbn(tabela.getString("isbn"));
				lv.setTitulo(tabela.getString("titulo"));
				lv.setValor(tabela.getDouble("valor"));
				
				lista.add(lv);
			}
			tabela.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public Livro pesquisar(String pesquisa, PesquisaLivro tipoPesquisa) {
		ResultSet tabela;
		Livro lv = new Livro();
		String sql = "select * from " + getSchema() + ".livro";
		
		switch (tipoPesquisa) {
		case CODIGO: 
			sql += " where idlivro = " + pesquisa;
			break;
		case TITULO:
			sql += " where upper(titulo) = " + pesquisa.toUpperCase() + " order by titulo";
			break;
		case AUTOR:
			sql += " where upper(autor) = " + pesquisa.toUpperCase();
			break;
		case EDITORA:
			sql += " where upper(editora) = " + pesquisa.toUpperCase();
			break;
		case ISBN:
			sql += " where upper(isbn) = " + pesquisa.toUpperCase();
			break;
		case VALOR:
			sql += " where valor = " + pesquisa;
			break;
		default: return null;
		}
		
		tabela = getCon().query(sql);
		
		try {
			if (tabela.next()) {
				lv.setCodigo(tabela.getInt("idlivro"));
				lv.setAutor(tabela.getString("autor"));
				lv.setEditora(tabela.getString("editora"));
				lv.setIsbn(tabela.getString("isbn"));
				lv.setTitulo(tabela.getString("titulo"));
				lv.setValor(tabela.getDouble("valor"));
			}
			tabela.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lv;
	}

	private static String prepararSqlAlteracao(String schema) {
		StringBuilder updateSql = new StringBuilder()
				.append("update "+ schema + ".livro")
				.append(" set titulo = ?,")
				.append(" isbn = ?,")
				.append(" autor = ?,")
				.append(" editora = ?,")
				.append(" valor = ?")
				.append(" where idlivro = ?");
				
		return updateSql.toString();
	}
	private static String prepararSqlInclusao(String schema) {
		StringBuilder insertSql = new StringBuilder()
				.append("insert into "+ schema + ".livro")	
				.append(" (titulo, isbn, autor, editora, valor)")
				.append(" values ")
				.append(" (?, ?, ?, ?, ?)");		
		
		return insertSql.toString();
	}
	private static String prepararSqlExclusao(String schema) {
		StringBuilder deleteSql = new StringBuilder()
				.append("delete from "+ schema + ".livro")
				.append(" where idlivro = ?");
		
		return deleteSql.toString();
	}
	
	
}

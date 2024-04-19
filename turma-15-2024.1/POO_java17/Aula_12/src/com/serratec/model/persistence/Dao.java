package com.serratec.model.persistence;

import java.sql.PreparedStatement;
import java.sql.Statement;

import com.serratec.model.connection.Conexao;

public abstract class Dao<T, E> implements IDao<T, E>{
	private Conexao con;
	private String schema;	
	
	protected PreparedStatement pInclusao;
	protected PreparedStatement pAlteracao;
	protected PreparedStatement pExclusao;
	
	public Dao(Conexao con, String schema, String... sql) {
		this.con = con;
		this.schema = schema;		
		
		executarPreparedStatment(sql[0], sql[1], sql[2]);
	}
	
	protected void executarPreparedStatment(String pSqlInclusao,
			String pSqlAlteracao, String pSqlExclusao) {	
		this.pInclusao = preparar(pSqlInclusao, Statement.RETURN_GENERATED_KEYS);
		this.pAlteracao = preparar(pSqlAlteracao);
		this.pExclusao = preparar(pSqlExclusao);
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
	
	public Conexao getCon() {
		return con;
	}

	public String getSchema() {
		return schema;
	}
	
}

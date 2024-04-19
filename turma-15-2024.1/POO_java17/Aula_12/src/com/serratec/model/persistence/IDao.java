package com.serratec.model.persistence;

import java.util.List;

public interface IDao<T, E> {	
	
	public int incluir(T objeto);
	public int alterar(T objeto);
	public int excluir(T objeto);
	public List<T> listar();
	public T pesquisar(String pesquisa, E e);
}

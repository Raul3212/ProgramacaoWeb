package br.ufc;

import java.util.List;

public interface IDAO<E> {

	public void inserir(E e);
	public void alterar(E e);
	public List<E> listar();
	public E recuperar(long id);
	
}

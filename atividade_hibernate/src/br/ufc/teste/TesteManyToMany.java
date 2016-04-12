package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteManyToMany {

	public static void main(String[] args) {
		EntityManagerFactory fab = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = fab.createEntityManager();
		
		//Faltou os testes Many to Many entre ALuno e Disciplina (não deu tempo)
		
		manager.close();
		fab.close();
		
	}

}

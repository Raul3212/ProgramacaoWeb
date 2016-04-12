package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Disciplina;
import br.ufc.Universidade;

public class TesteOneToMany {

	public static void main(String[] args) {

		EntityManagerFactory fab = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = fab.createEntityManager();
		
//		Universidade universidade = new Universidade();
//		universidade.setNome("UFQ - UNIVERSIDADE FEDERAL DE QUIXADÁ");
		
//		manager.getTransaction().begin();
//		manager.persist(universidade);
//		manager.getTransaction().commit();
		
		
		Universidade u = manager.find(Universidade.class, 1L);
		System.out.println(u.getUniId() + " - " + u.getNome());
		
		Disciplina d1 = new Disciplina();
		d1.setNome("BANCO DE DADOS");
		d1.setUniversidade(u);
		
		Disciplina d2 = new Disciplina();
		d2.setNome("PROGRAMAÇÃO ORIENTADA A OBJETOS");
		d2.setUniversidade(u);
		
		manager.getTransaction().begin();
		manager.persist(d1);
		manager.persist(d2);
		manager.getTransaction().commit();
		
		manager.close();
		fab.close();
		
	}

}

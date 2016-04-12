package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Disciplina;
import br.ufc.Ementa;

public class TesteOneToOne {

	public static void main(String[] args) {
		
		EntityManagerFactory fab = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = fab.createEntityManager();
		
		Disciplina d = new Disciplina();
		d.setNome("PROGRAMAÇÃO WEB");
		
		Ementa e = new Ementa();
		e.setNome("PROGRAMAÇÃO WEB - EMENTA");
		
		d.setEmenta(e);
		e.setDisciplina(d);
		
		manager.getTransaction().begin();
		manager.persist(d);
		manager.getTransaction().commit();
		
		manager.close();
		fab.close();
		
	}

}

package br.ufc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DisciplinaDAO implements IDAO<Disciplina>{

	@Override
	public void inserir(Disciplina e) {
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		
		manager.getTransaction().begin(); //Inicia uma transação com o banco de dados
		manager.persist(e); //Persistir o bjeto no banco
		manager.getTransaction().commit(); //Faz um commit na transação
		
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
	}

	@Override
	public void alterar(Disciplina e) {
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		
		manager.getTransaction().begin(); //Inicia uma transação com o banco de dados
		manager.merge(e); //Mescla através da chave primária (update) 
		manager.getTransaction().commit(); //Faz um commit na transação
		
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
	}

	@Override
	public List<Disciplina> listar() {
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		List<Disciplina> disciplinas = manager.createQuery("select d from disciplina as d", Disciplina.class).
				getResultList();
		
		manager.close();
		fabrica.close();
		
		return disciplinas;
		
	}

	@Override
	public Disciplina recuperar(long id) {
		
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		Disciplina d = manager.find(Disciplina.class, id);
		
		manager.close();
		fabrica.close();
		
		return d;
		
	}

	
	
	
}

package br.ufc;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlunoDAO {

	public void inserir(Aluno aluno){
		
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		
		manager.getTransaction().begin(); //Inicia uma transação com o banco de dados
		manager.persist(aluno); //Persistir o bjeto no banco
		manager.getTransaction().commit(); //Faz um commit na transação
		
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
		
	}
	
	public void alterar(Aluno aluno){
	
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		
		manager.getTransaction().begin(); //Inicia uma transação com o banco de dados
		manager.merge(aluno); //Mescla através da chave primária (update) 
		manager.getTransaction().commit(); //Faz um commit na transação
		
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
		
	}
	
	public List<Aluno> listar(){
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		List<Aluno> alunos = manager.createQuery("select a from aluno as a", Aluno.class).
				getResultList();
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
		
		return alunos;
		
	}
	
	public Aluno recuperar(long id){
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc"); 
		
		EntityManager manager = fabrica.createEntityManager();
		
		//Lógica de banco de dados
		Aluno aluno = manager.find(Aluno.class, id);
		//------ FIM da lógica ------
		
		manager.close();
		fabrica.close();
		
		return aluno;
	}
	
}

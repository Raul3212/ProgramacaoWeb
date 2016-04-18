package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Customer;

public class CustomerDAO {

	public void inserir(Customer customer){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(customer);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}
	
	public List<Customer> listar(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = factory.createEntityManager();
		
		List<Customer> customers = manager.
				createQuery("select c from CUSTOMER as c", Customer.class).getResultList();
	
		return customers;
	}
	
}

package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Product;

public class ProductDAO {

	public void inserir(Product p){
		
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
		manager.persist(p);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
	}
	
	public List<Product> listar(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		
		EntityManager manager = factory.createEntityManager();
		
		List<Product> products = manager.
				createQuery("select p from PRODUCT as p", Product.class).getResultList();
		
		return products;
	}
	
}

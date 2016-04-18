package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Customer;
import br.ufc.Product;

public class ManyToManyTest {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		EntityManager manager = fabrica.createEntityManager();
		
		Customer c = new Customer();
		c.setName("RAUL_CUSTOMER");
//		Product p = new Product();
//		p.setName("PRODUCT-Z");
		
		
		manager.getTransaction().begin();
		manager.persist(c);
		manager.getTransaction().commit();
		
		manager.close();
		fabrica.close();
		
		
	}

}

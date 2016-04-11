package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Customer;
import br.ufc.Invoice;
import br.ufc.Order;

public class OneToManyTest {

	public static void main(String[] args) {
	
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		
		EntityManager manager = fabrica.createEntityManager();
		
		/***** Inserir Costumer
		Customer customer = new Customer();
		customer.setName("RAUL_CUSTOMER");
		
		manager.getTransaction().begin();
		manager.persist(customer); //Persiste os objetos customer, order e invoice 
		manager.getTransaction().commit();
		******/
		
		/****** Vincular Order a um costumer
		Customer customer = manager.find(Customer.class, 5L);
		System.out.println(customer.getName());
		
		Order order1 = new Order();
		order1.setName("Raul - Pedido 1");
		order1.setCustomer(customer);
		
		Order order2 = new Order();
		order2.setName("Raul - Pedido 2");
		order2.setCustomer(customer);
		
		manager.getTransaction().begin();
		manager.persist(order1);
		manager.persist(order2);
		manager.getTransaction().commit();
		********/
		
		Customer customer = manager.find(Customer.class, 5L);
		System.out.println("Pedidos de: " + customer.getName());
		
		for(Order o : customer.getOrders()){
			System.out.println(o.getName());
		}
		
		manager.close();
		fabrica.close();
		
	}

}

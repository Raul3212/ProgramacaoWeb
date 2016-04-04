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
		
		Customer customer = new Customer();
		customer.setName("RAUL_CUSTOMER");
		
		Order order = new Order();
		order.setName("RAUL_ORDER");
		
		customer.getOrders().add(order); //Adiciona order à colação do customer
		order.setCustomer(customer); //Relaciona order com customer
		
		Invoice invoice = new Invoice();
		invoice.setName("RAUL_INVOICE");
		
		order.setInvoice(invoice);
		invoice.setOrder(order);
		
		manager.getTransaction().begin();
		manager.persist(customer); //Persiste os objetos customer, order e invoice 
		manager.getTransaction().commit();
		
		manager.close();
		fabrica.close();
		
	}

}

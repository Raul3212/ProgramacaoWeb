package br.ufc.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.Invoice;
import br.ufc.Order;

public class OneToOneTest {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.
				createEntityManagerFactory("teste_aula_cc");
		
		EntityManager manager = fabrica.createEntityManager();
		
		Order order = new Order();
		order.setName("RAUL_ORDER");
		
		Invoice invoice = new Invoice();
		invoice.setName("RAUL_INVOICE");
		
		order.setInvoice(invoice); //Relaciona os objetos
		invoice.setOrder(order);
		
//		manager.getTransaction().begin();
//		manager.persist(order); //Persiste os objetos order e invoice (o objeto order [mais forte] deve vir aqui) 
//		manager.getTransaction().commit();
		
		manager.getTransaction().begin();
		Order refOrder = manager.find(Order.class, 4L);
		manager.getTransaction().commit();
		
		System.out.println(refOrder.getName());
		System.out.println(refOrder.getInvoice().getName());
		
		manager.close();
		fabrica.close();
		
	}
	
}

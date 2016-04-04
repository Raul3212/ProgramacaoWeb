package br.ufc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "ORDER_INVOICE")
public class Invoice {

	@Id
	@Column(name = "INVOICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long invoiceId;
	
	@Column(name = "ORDER_ID",  //name tem que ser idêntico ao definido na classe Order
			insertable = false, 
			updatable = false
			)
	private long orderId;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@Column(name = "NAME")
	private String name;
	
	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

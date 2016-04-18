package br.ufc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="ORDER_INVOICE")
public class Invoice {
	
	@Id
	@Column(name="INVOICE_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long invoiceId;
	
	@Column(name="ORDER_ID",insertable=false,updatable=false)
	private Long orderId;
	
	@OneToOne(optional=false)
	@JoinColumn(name="ORDER_ID")
	private Order order;

	@Column(name="NAME")
	private String name;
	
	/*GET'S E SET'S*/
	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
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








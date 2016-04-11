package br.ufc;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "ORDERS")
public class Order {

	@Id
	@Column(name = "ORDER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId; 
	
	@OneToOne(optional = false, 
			cascade = CascadeType.ALL, 
			mappedBy = "order", //atributo definido na classe Invoice
			targetEntity = Invoice.class
			)
	private Invoice invoice;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID",
				referencedColumnName = "CUST_ID" 
				)
	private Customer customer;
	
	@Column(name =  "CUST_ID", insertable = false, updatable = false)
	private long customerId;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_ORDER",
			joinColumns = @JoinColumn(name = "ORDER_ID", 
						referencedColumnName = "ORDER_ID"
					),
			inverseJoinColumns = @JoinColumn(name = "PROD_ID",
						referencedColumnName = "PROD_ID"
					)		
			)
	private List<Product> productList;
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

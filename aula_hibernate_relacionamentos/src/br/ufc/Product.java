package br.ufc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

public class Product {

	@Id
	@Column(name = "PROD_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prodId;
	
	@Column(name = "NAME")
	private String name;
	
	@ManyToMany(mappedBy = "productList", fetch = FetchType.LAZY)
	List<Order> orderList;

	public long getProdId() {
		return prodId;
	}

	public void setProdId(long prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
}

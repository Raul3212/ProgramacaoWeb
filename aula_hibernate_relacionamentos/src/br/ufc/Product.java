package br.ufc;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="PRODUCT")
public class Product {

	@Id
	@Column(name="PROD_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long prodId;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy="productList",fetch=FetchType.LAZY)
	private List<Order> orderList;

	/*Get's e Set's*/
	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
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
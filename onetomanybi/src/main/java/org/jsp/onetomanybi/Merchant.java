package org.jsp.onetomanybi;

import java.util.List;

import javax.persistence.*;

@Entity
public class Merchant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gst_name;
	private long phone;
	private String password;
	
	@OneToMany(mappedBy = "merchant",cascade = CascadeType.ALL)
	private List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGst_name() {
		return gst_name;
	}
	public void setGst_name(String gst_name) {
		this.gst_name = gst_name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", gst_name=" + gst_name + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
	
	
}

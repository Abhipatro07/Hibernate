package org.jsp.onetomanybi;

import java.util.Arrays;

import javax.persistence.*;

public class SaveMerchantAndProducts 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		Merchant m=new Merchant();
		m.setName("Harish");
		m.setGst_name("hari123");
		m.setPhone(8919623122l);
		m.setPassword("harish");
		
		Product p1=new Product();
		p1.setName("Tv");
		p1.setBrand("sony");
		p1.setCategory("Electronics");
		p1.setMerchant(m);
		
		Product p2=new Product();
		p2.setName("Mobile");
		p2.setBrand("iqoo");
		p2.setCategory("Electronics");
		p2.setMerchant(m);
		
		Product p3=new Product();
		p3.setName("Fan");
		p3.setBrand("Usha");
		p3.setCategory("Electrical");
		p3.setMerchant(m);
		
		m.setProducts(Arrays.asList(p1,p2,p3));
		
		man.persist(m);
		tran.commit();
	}
}

package org.jsp.marchentproduct.dao;
import java.util.List;

import javax.persistence.*;
import org.jsp.marchentproduct.dto.Marchent;
import org.jsp.marchentproduct.dto.Product;

public class ProductDao {
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	EntityManager man = fac.createEntityManager();
	
	
	public Product addProduct(int mid, Product p) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Marchent mdb = man.find(Marchent.class, mid);
		if(mdb != null) {
			mdb.getProducts().add(p);
			p.setMarchent(mdb);
			man.persist(p);
			tran.commit();
			return p;
		}
		else {
			return null;
		}
	}


	public Product updateProduct(Product p) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Product pdb = man.find(Product.class, p.getId());
		if(pdb != null) {
			pdb.setName(p.getName());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			tran.commit();
			return pdb;
		}
		else {
			return null;
		}
	}
	
	
	public List<Product> findProductsByMarchentId(int mid) {
		Query q = man.createQuery("select m.products from Marchent m where m.id = ?1");
		q.setParameter(1, mid);
		List<Product> lp = q.getResultList();
		return lp;		
	}


	public List<Product> findProductsByBrand(String brand) {
		Query q = man.createQuery("SELECT p FROM Product p WHERE p.brand = ?1");
		q.setParameter(1, brand);
		List<Product> lp = q.getResultList();
		return lp;
	}


	public List<Product> findProductsByCategory(String category) {
		Query q = man.createQuery("SELECT p FROM Product p WHERE p.category = ?1");
		q.setParameter(1, category);
		List<Product> lp = q.getResultList();
		return lp;
	}

}





























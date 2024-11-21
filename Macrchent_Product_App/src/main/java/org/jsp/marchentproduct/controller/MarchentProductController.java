package org.jsp.marchentproduct.controller;
import java.util.*;
import javax.persistence.*;

import org.jsp.marchentproduct.dao.MarchentDao;
import org.jsp.marchentproduct.dao.ProductDao;
import org.jsp.marchentproduct.dto.Marchent;
import org.jsp.marchentproduct.dto.Product;

public class MarchentProductController {
	static Scanner sc = new Scanner(System.in);
	static MarchentDao mdao = new MarchentDao();
	static ProductDao pdao = new ProductDao();
	
	public static void main(String[] args) {
		System.out.println("1. Save Marchent");
		System.out.println("2. Update Marchent");
		System.out.println("3. Find Marchent by id");
		System.out.println("4. Verify Marchent by Email and Password");
		System.out.println("5. Verify Marchent by Phone and password");
		System.out.println("6. Add Product");
		System.out.println("7. Update Product");
		System.out.println("8. Find Products by Marchent_id");
		System.out.println("9. Find Products by brand");
		System.out.println("10. Find Products by Category");
		
		System.out.println("Enter your choice: ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			saveMarchent();			
			break;
		
		case 2:
			updateMarchent();			
			break;
			
		case 3:
			findMarchentById();			
			break;
			
		case 4:
			verifyMarchentByEmailAndPassword();			
			break;
			
		case 5:
			verifyMarchentByPhoneAndPassword();			
			break;
			
		case 6:
			addProduct();			
			break;
			
		case 7:
			updateProduct();			
			break;
			
		case 8:
			findProductsByMarchentId();			
			break;
			
		case 9:
		    findProductsByBrand();
		    break;

		case 10:
		    findProductsByCategory();
		    break;

		default:
			System.err.println("Invalid Choice");
			break;
		}
	
	}

	private static void saveMarchent() {
		System.out.println("Enter the Marchent Info to Save: name , phone , gst_number , Email , Password");
		String name = sc.next();
		long phone = sc.nextLong();
		String gst_number = sc.next();
		String email = sc.next();
		String password = sc.next();
		Marchent m = new Marchent();
		m.setName(name);
		m.setPhone(phone);
		m.setGst_number(gst_number);
		m.setEmail(email);
		m.setPassword(password);
		Marchent mdb = mdao.saveMarchent(m);
		System.out.println("Marchent is saved with an id: " + mdb.getId());
	}
	
	private static void updateMarchent() {
		System.out.println("Enter the Marchent id");
		System.out.println("Enter Marchent name , phone , gst_numer , email , password");
		Marchent m = new Marchent();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setPhone(sc.nextLong());
		m.setGst_number(sc.next());
		m.setEmail(sc.next());
		m.setPassword(sc.next());
		Marchent mdb = mdao.updateMarchent(m);
		if(mdb != null) {
			System.out.println("Marchent is Updated");
		}
		else {
			System.err.println("Marchent is not udated since id is Invalid");
		}
	}
	
	private static void findMarchentById() {
		System.out.println("Enter the Marchent id: ");
		int mid = sc.nextInt();
		Marchent mdb = mdao.findMarchentById(mid);
		if(mdb != null) {
			System.out.println(mdb);
		}
		else {
			System.err.println("NoMarchent Info Found since id is Inavlid");
		}
	}
	
	private static void verifyMarchentByEmailAndPassword() {
		System.out.println("Enter the Email: ");
		String em = sc.next();
		System.out.println("Enter the Password: ");
		String pw = sc.next();
		Marchent mdb = mdao.verifyMarchentByEmailAndPassword(em,pw);
		if(mdb != null) {
			System.out.println("Marchent is Verified");
		}
		else {
			System.err.println("Inavlid credentials");
		}
	}
	
	private static void verifyMarchentByPhoneAndPassword() {
		System.out.println("Enter the Phone no: ");
		long ph = sc.nextLong();
		System.out.println("Enter the Password: ");
		String pw = sc.next();
		Marchent mdb = mdao.verifyMarchentByPhoneAndPassword(ph,pw);
		if(mdb != null) {
			System.out.println("Marchent is Verified");
		}
		else {
			System.err.println("Inavlid credentials");
		}
	}
	
	private static void addProduct() {
		System.out.println("Enter Marchent id to add the product: ");
		int mid = sc.nextInt();
		System.out.println("Enter Product Info -----> name , brand , category");
		Product p = new Product();
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		Product pdb = pdao.addProduct(mid , p);				
		if(pdb != null) {
			System.out.println("Product is added Successfully");
		}
		else {
			System.err.println("Product is not added since Product id is Invalid");
		}
	}
	
	private static void updateProduct() {
		System.out.println("Enter the Product id");
		System.out.println("Enter Product name , brand , category");
		Product p = new Product();
		p.setId(sc.nextInt());
		p.setName(sc.next());
		p.setBrand(sc.next());
		p.setCategory(sc.next());
		Product pdb = pdao.updateProduct(p);
		if(pdb != null) {
			System.out.println("Product is Updated");
		}
		else {
			System.err.println("Product is not udated since id is Invalid");
		}
		
	}

	private static void findProductsByMarchentId() {
		System.out.println("Enter Marchent id to find Products: ");
		int mid = sc.nextInt();
		List<Product> lpdb =  pdao.findProductsByMarchentId(mid);
		if(lpdb.size() > 0) {
			for (Product p : lpdb) {
				System.out.println(p);
			}
		}
		else {
			System.err.println("No Product Info has been found since the Marchent id is Inavlid");
		}
	}
	
	private static void findProductsByBrand() {
		System.out.println("Enter the brand to find products: ");
	    String brand = sc.next();
	    List<Product> products = pdao.findProductsByBrand(brand);
	    if (products.size() > 0) {
	        for (Product product : products) {
	            System.out.println(product);
	        }
	    } else {
	        System.err.println("No products found for the given brand.");
	    }
	}
	
	private static void findProductsByCategory() {
		System.out.println("Enter Product Category: ");
	    String category = sc.next();
	    List<Product> products = pdao.findProductsByCategory(category);
	    if (products.size() > 0) {
	        for (Product product : products) {
	            System.out.println(product);
	        }
	    } else {
	        System.err.println("No products found for the given category.");
	    }
	}

}





































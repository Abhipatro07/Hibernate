package org.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.*;
public class FindMerchantByProductID 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product Id!!");
		int pid=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select p.merchant from Product p where p.id=?1");
		q.setParameter(1, pid);
		
		try {
			Merchant m=(Merchant) q.getSingleResult();
			System.out.println(m);
		} catch (NoResultException e) {
			System.err.println("No Merchant info found ");
		}
	}
}

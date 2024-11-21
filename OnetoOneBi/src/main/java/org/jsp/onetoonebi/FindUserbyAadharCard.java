package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.*;
public class FindUserbyAadharCard 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter AadharCard Id?");
		int aid=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select u from User u where u.card.id=?1");
		q.setParameter(1, aid);
		try {
			User u=(User) q.getSingleResult();
			System.out.println(u);
		} catch (NoResultException e) {
			System.err.println("No User found since id is invalid!!");
		}
		
	}
}

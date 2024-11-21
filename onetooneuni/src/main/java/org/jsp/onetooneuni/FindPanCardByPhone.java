package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.*;

public class FindPanCardByPhone 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Phone Number");
		long ph=sc.nextLong();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select p.card from Person p where p.phone=?1");
		q.setParameter(1, ph);
		
		try {
			PanCard p1=(PanCard) q.getSingleResult();
			System.out.println(p1);
		} catch (NoResultException e) {
			System.out.println("No PanCard info found!!");
		}
	}
}

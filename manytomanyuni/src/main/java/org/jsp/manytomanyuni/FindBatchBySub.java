package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.*;

public class FindBatchBySub 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Subject");
		String sub=sc.next();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select b from Batch b where b.subject=?1");
		q.setParameter(1, sub);
		try {
			Batch b=(Batch) q.getSingleResult();
			System.out.println(b);
		} catch (NoResultException e) {
			System.err.println("No Batch Found ..");
		}
	}
}

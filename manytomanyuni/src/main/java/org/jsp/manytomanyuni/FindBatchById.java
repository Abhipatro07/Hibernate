package org.jsp.manytomanyuni;

import java.util.Scanner;

import javax.persistence.*;

public class FindBatchById {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id to Fetch!!");
		int bid=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Batch b=man.find(Batch.class, bid);
		if(b!=null)
		{
			System.out.println(b);
		}
		else {
			System.err.println("No Batch Found...");
		}
	}
}

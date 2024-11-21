package org.jsp.onetooneuni;

import java.util.Scanner;

import javax.persistence.*;

public class FindPersonById
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Person p=man.find(Person.class, id);
		if(p!=null)
		{
			System.out.println(p);
		}
		else {
			System.err.println("No Person Info");
		}

	}
}

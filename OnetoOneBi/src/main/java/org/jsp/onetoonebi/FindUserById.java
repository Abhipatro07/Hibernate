package org.jsp.onetoonebi;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindUserById 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter User id to find the user info");
		int uid=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		User u=man.find(User.class, uid);
		if(u!=null)
		{
			System.out.println(u);
		}
		else {
			System.err.println("No user info found since id is invalid");
		}
	}
}

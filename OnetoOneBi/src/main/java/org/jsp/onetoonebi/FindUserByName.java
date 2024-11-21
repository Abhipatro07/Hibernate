package org.jsp.onetoonebi;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindUserByName 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Name??");
		String name=sc.next();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);
		List<User>lm=q.getResultList();
		if(lm.size()>0)
		{
			for(User u:lm)
			{
				System.out.println(u);
			}
		}
		else {
			System.err.println("No user info found!!");
		}
	}
}

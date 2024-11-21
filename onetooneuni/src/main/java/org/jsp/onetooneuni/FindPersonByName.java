package org.jsp.onetooneuni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindPersonByName
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter name");
		String name=sc.next();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select p from Person p where p.name=?1");
		q.setParameter(1, name);
		List<Person> lm=q.getResultList();
		if(lm.size()>0)
		{
			for(Person per:lm)
			{
				System.out.println(per);
			}
		}
		else {
			System.err.println("No Person Info found");
		}
	}
}

package org.jsp.onetomany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindEmpsById 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Dept id");
		int did=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Query q=man.createQuery("select d.emps from Department d where d.id=?1");
		q.setParameter(1, did);
		List<Employee> lemps=q.getResultList();
		if(lemps.size()>0)
		{
			for (Employee emp : lemps) {
				System.out.println(emp);
			}
		}
		else {
			System.err.println("No Employee info found");
		}
	}
}

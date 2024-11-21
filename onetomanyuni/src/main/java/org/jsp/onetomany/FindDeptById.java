package org.jsp.onetomany;

import java.util.Scanner;

import javax.persistence.*;

public class FindDeptById 
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Dept id");
		int id=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		
		Department d=man.find(Department.class, id);
		if(d!=null)
		{
			System.out.println(d);
		}
		else {
			System.err.println("No Dept info found");
		}
	}
	
}

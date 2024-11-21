package org.jsp.onetomanybi;

import java.util.Scanner;

import javax.persistence.*;

public class FindMerchantByid 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Merchant id !!");
		int mid=sc.nextInt();
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		Merchant m=man.find(Merchant.class, mid);
		if(m!=null)
		{
			System.out.println(m);
		}
		else
		{
			System.err.println("No merchant info found!!");
		}
	}
}

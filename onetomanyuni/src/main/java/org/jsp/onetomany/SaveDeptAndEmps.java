package org.jsp.onetomany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

public class SaveDeptAndEmps 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		Department d=new Department();
		d.setName("Development");
		d.setLoc("Bangalore");
		
		Employee e1=new Employee();
		e1.setName("Rakesh");
		e1.setDesg("manager");
		
		Employee e2=new Employee();
		e2.setName("sai");
		e2.setDesg("tester");
		
		Employee e3=new Employee();
		e3.setName("Rakesh");
		e3.setDesg("TL");
		
		
		
//		List<Employee> lemps=new ArrayList<Employee>();
//		lemps.add(e1);
//		lemps.add(e2);
//		lemps.add(e3);
//		d.setEmps(lemps);

		d.setEmps(Arrays.asList(e1,e2,e3));
		man.persist(d);
		tran.commit();
	}
}

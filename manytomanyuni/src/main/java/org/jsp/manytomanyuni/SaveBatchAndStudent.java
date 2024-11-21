package org.jsp.manytomanyuni;

import java.util.Arrays;

import javax.persistence.*;

public class SaveBatchAndStudent 
{
	public static void main(String[] args) {
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		Batch b1=new Batch();
		b1.setTrainer("Pavan");
		b1.setSubject("JAVA");
		b1.setBatch_code("JAVAB1");
		
		Batch b2=new Batch();
		b2.setTrainer("Sharath");
		b2.setSubject("SQL");
		b2.setBatch_code("SQLB2");
		
		Student s1=new Student();
		s1.setName("Rakesh");
		s1.setPerc(78.2);
		s1.setPhone(6303860006l);
		
		Student s2=new Student();
		s2.setName("Prabha");
		s2.setPerc(80.2);
		s2.setPhone(7894561230l);
		
		Student s3=new Student();
		s3.setName("Rahul");
		s3.setPerc(75.3);
		s3.setPhone(1234568990l);
		
		b1.setStudents(Arrays.asList(s1,s2,s3));
		b2.setStudents(Arrays.asList(s1,s3)); 
		man.persist(b1);
		man.persist(b2);
		tran.commit();
		
	}
}

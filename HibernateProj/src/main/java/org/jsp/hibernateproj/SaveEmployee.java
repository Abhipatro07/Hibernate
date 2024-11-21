package org.jsp.hibernateproj;
import java.io.Serializable;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sef = conf.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tran = ses.getTransaction();
		tran.begin();
		Employee e = new Employee();
		e.setName("Sujit");
		e.setPhone(9573165829l);
		e.setDesg("Manager");
		e.setSalary(45000);
		e.setEmail("sujitpatro2002@gmail.com");
		e.setPassword("Sujit@2002");
		
		int id = (Integer) ses.save(e);
		tran.commit();
		System.out.println("Employee is saved with an id " + id);
	}

}

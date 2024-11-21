package org.jsp.hibernateproj;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FindEmployeeByLoad {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sef = conf.buildSessionFactory();
		Session ses = sef.openSession();
		
		try {
			Employee e = ses.load(Employee.class, 1);
			System.out.println(e);
		}
		catch(ObjectNotFoundException e) {
			System.err.println("Eployee not found since it is invalid id");
		}
	}

}

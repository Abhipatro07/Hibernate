package org.jsp.hibernateproj;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FindEmployeeByGet {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sef = conf.buildSessionFactory();
		Session ses = sef.openSession();
		Employee e = ses.get(Employee.class, 22);
		
		if(e != null) {
			System.out.println(e);
		}
		else {
			System.err.println("Employee is not found since id is invalid");
		}
	}

}

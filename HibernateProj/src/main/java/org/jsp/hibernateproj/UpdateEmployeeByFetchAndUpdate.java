package org.jsp.hibernateproj;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeByFetchAndUpdate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id to update employee details: ");
		int eid = sc.nextInt();
		
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sef = conf.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tran = ses.getTransaction();
		tran.begin();
		Employee e = ses.get(Employee.class, eid);   // Persistance state
		if(e != null) {
			e.setName("Akash");
			e.setPhone(9647532158l);
			e.setEmail("akash@gmail.com");
			tran.commit();
		}
		else {
			System.err.println("Employee details is not updated since employee id is invalid");
		}
	}

}

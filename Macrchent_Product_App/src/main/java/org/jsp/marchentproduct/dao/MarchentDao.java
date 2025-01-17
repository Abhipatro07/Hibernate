package org.jsp.marchentproduct.dao;
import javax.persistence.*;
import org.jsp.marchentproduct.dto.Marchent;

public class MarchentDao {
	
	EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
	EntityManager man = fac.createEntityManager();
	

	public Marchent saveMarchent(Marchent m) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		man.persist(m);
		tran.commit();
		return m;
	}


	public Marchent updateMarchent(Marchent m) {
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		Marchent mdb = man.find(Marchent.class, m.getId());
		if(mdb != null) {
			mdb.setName(m.getName());
			mdb.setPhone(m.getPhone());
			mdb.setGst_number(m.getGst_number());
			mdb.setEmail(m.getEmail());
			mdb.setPassword(m.getPassword());
			tran.commit();
			return mdb;
		}
		else {
			return null;
		}
	}

	
	public Marchent findMarchentById(int mid) {
		return man.find(Marchent.class, mid);		
	}

	
	public Marchent verifyMarchentByEmailAndPassword(String em, String pw) {
		Query q = man.createQuery("select m from Marchent m where m.email = ?1 and m.password = ?2");
		q.setParameter(1,em);
		q.setParameter(2,pw);
		try {
			Marchent mdb = (Marchent) q.getSingleResult();
			return mdb;
		} catch (NoResultException e) {
			return null;
		}		
	}
	
	public Marchent verifyMarchentByPhoneAndPassword(long ph, String pw) {
		Query q = man.createQuery("select m from Marchent m where m.email = ?1 and m.password = ?2");
		q.setParameter(1,ph);
		q.setParameter(2,pw);
		try {
			Marchent mdb = (Marchent) q.getSingleResult();
			return mdb;
		} catch (NoResultException e) {
			return null;
		}		
	}
	
}


































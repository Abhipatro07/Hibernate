package org.jsp.onetoonebi;

import javax.persistence.*;

public class SaveUserAndAadharCard 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		User u=new User();
		u.setName("Rakesh");
		u.setPhone(7780419124l);
		
		AadharCard card=new AadharCard();
		card.setNumber(123456789012l);
		card.setAddress("Hyderabad");
		card.setUser(u);
		u.setCard(card);
		man.persist(u);
		tran.commit();
	}
}

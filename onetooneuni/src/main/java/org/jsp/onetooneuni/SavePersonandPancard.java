package org.jsp.onetooneuni;

import javax.persistence.*;

public class SavePersonandPancard 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		Person p=new Person();
		p.setName("sai");
		p.setPhone(7989377290l);
		PanCard card=new PanCard();
		card.setNumber("BCD233");
		card.setPincode(516004);
		
		p.setCard(card);
		man.persist(p);
		man.persist(card);
		tran.commit();
	}
}

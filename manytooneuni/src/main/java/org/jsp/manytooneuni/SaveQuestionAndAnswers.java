package org.jsp.manytooneuni;

import javax.persistence.*;

public class SaveQuestionAndAnswers 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
		EntityManager man=fac.createEntityManager();
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		QuestionData q=new QuestionData();
		q.setQuestion("where is your native place?");
		q.setQuestionedBy("Harish");
		
		AnswerData a1=new AnswerData();
		a1.setAnswer("Kadapa");
		a1.setAnsweredby("Rakesh");
		a1.setQuestion(q);
		
		AnswerData a2=new AnswerData();
		a2.setAnswer("Kurnool");
		a2.setAnsweredby("Rahul");
		a2.setQuestion(q);
		
		AnswerData a3=new AnswerData();
		a3.setAnswer("Hyderabad");
		a3.setAnsweredby("Dhanush");
		a3.setQuestion(q);
		
		man.persist(a1);
		man.persist(a2);
		man.persist(a3);
		tran.commit();
		
	}
}

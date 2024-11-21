package org.jsp.manytooneuni;

import javax.persistence.*;

@Entity
public class QuestionData 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String questionedBy;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionedBy() {
		return questionedBy;
	}
	public void setQuestionedBy(String questionedBy) {
		this.questionedBy = questionedBy;
	}
	@Override
	public String toString() {
		return "QuestionData [id=" + id + ", question=" + question + ", questionedBy=" + questionedBy + "]";
	}
	
	
}

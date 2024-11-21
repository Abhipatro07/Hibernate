package org.jsp.manytooneuni;

import javax.persistence.*;

@Entity
public class AnswerData 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answer;
	private String answeredby;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionData question;
	
	public QuestionData getQuestion() {
		return question;
	}
	public void setQuestion(QuestionData question) {
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnsweredby() {
		return answeredby;
	}
	public void setAnsweredby(String answeredby) {
		this.answeredby = answeredby;
	}
	@Override
	public String toString() {
		return "AnswerData [id=" + id + ", answer=" + answer + ", answeredby=" + answeredby + "]";
	}
	
	
}

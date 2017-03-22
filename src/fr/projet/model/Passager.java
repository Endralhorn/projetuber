package fr.projet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="Passager")
@PrimaryKeyJoinColumn(name="PAS_ID", referencedColumnName="PER_ID")
public class Passager extends Personne{

	private static final long serialVersionUID = 1L;

	@Column(name = "PAS_MAILPAYPAL")
	private String mailPaypal;

	
	@OneToMany(mappedBy="course", fetch=FetchType.EAGER)
	private List<Course> courses;
	
	public String getMailPaypal() {
		return mailPaypal;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setMailPaypal(String mailPaypal) {
		this.mailPaypal = mailPaypal;
	}
	
	
	
}

package fr.projet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commentaire")
public class Commentaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COMM_ID")
	private int comm_id;
	
	@Column(name="COMM_NOTECONDUCTEUR")
	private String comm_noteConducteur;
	
	@Column(name="COMM_NOTEPASSAGER")
	private String comm_notePassager;
	
	@Column(name="COMM_COMMPASSAGER")
	private String comm_commPassager;
	
	@Column(name="COMM_COMMCONDUCTEUR")
	private String comm_commConducteur;
	

	@ManyToOne
	@JoinColumn(name="COMM_COURSE_ID")
	private Course course;


	public int getComm_id() {
		return comm_id;
	}


	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}


	public String getComm_noteConducteur() {
		return comm_noteConducteur;
	}


	public void setComm_noteConducteur(String comm_noteConducteur) {
		this.comm_noteConducteur = comm_noteConducteur;
	}


	public String getComm_notePassager() {
		return comm_notePassager;
	}


	public void setComm_notePassager(String comm_notePassager) {
		this.comm_notePassager = comm_notePassager;
	}


	public String getComm_commPassager() {
		return comm_commPassager;
	}


	public void setComm_commPassager(String comm_commPassager) {
		this.comm_commPassager = comm_commPassager;
	}


	public String getComm_commConducteur() {
		return comm_commConducteur;
	}


	public void setComm_commConducteur(String comm_commConducteur) {
		this.comm_commConducteur = comm_commConducteur;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}

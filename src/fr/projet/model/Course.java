package fr.projet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUR_ID")
	private int cour_id;
	

	@Column(name="COUR_DEPART")
	private String cour_depart;
	
	@Column(name="COUR_ARRIVEE")
	private String cour_arrivee;
	
	@Column(name="COUR_VALIDATION")
	private boolean cour_validation;
	
	
	@ManyToOne
	@JoinColumn(name="COUR_CONDUCTEUR_ID")
	private Conducteur conducteur;
	
	
	@ManyToOne
	@JoinColumn(name="COUR_PASSAGER_ID")
	private Passager passager;
	
	@OneToMany(mappedBy="course", fetch=FetchType.EAGER)
	private List<Commentaire> commentaires;
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	
	public int getCour_id() {
		return cour_id;
	}


	public void setCour_id(int cour_id) {
		this.cour_id = cour_id;
	}


	public String getCour_depart() {
		return cour_depart;
	}


	public void setCour_depart(String cour_depart) {
		this.cour_depart = cour_depart;
	}


	public String getCour_arrivee() {
		return cour_arrivee;
	}


	public void setCour_arrivee(String cour_arrivee) {
		this.cour_arrivee = cour_arrivee;
	}


	public boolean getCour_validation() {
		return cour_validation;
	}


	public void setCour_validation(boolean cour_validation) {
		this.cour_validation = cour_validation;
	}


	public int getCour_statut() {
		return cour_statut;
	}


	public void setCour_statut(int cour_statut) {
		this.cour_statut = cour_statut;
	}


	public Date getCour_date() {
		return cour_date;
	}


	public void setCour_date(Date cour_date) {
		this.cour_date = cour_date;
	}


	public Conducteur getConducteur() {
		return conducteur;
	}


	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}


	public Passager getPassager() {
		return passager;
	}


	public void setPassager(Passager passager) {
		this.passager = passager;
	}


	@Column(name="COUR_STATUT")
	private int cour_statut;
	
	@Column(name="COUR_DATE")
	private Date cour_date;
	
	
	
}

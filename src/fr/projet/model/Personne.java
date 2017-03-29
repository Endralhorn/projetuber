package fr.projet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne")
@Table(name="Personne")
public class Personne implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int id_personne;
	
	@Column(name="PER_NOM")
	private String nom;
	
	@Column(name="PER_PRENOM")
	private String prenom;
	
	@Column(name="PER_TEL")
	private int telephone;
	
	@Column(name="PER_EMAIL")
	private String eMail;
	
	@Column(name="PER_USERNAME")
	private String username;
	
	@Column(name="PER_MOTPASS")
	private String motPass;
	
	@Column(name="PER_DATENAISSANCE")
	private Date dateNaissance = new Date();
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMotPass() {
		return motPass;
	}
	public void setMotPass(String motPass) {
		this.motPass = motPass;
	}
	public int getId_personne() {
		return id_personne;
	}
	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	
	
	
	
}

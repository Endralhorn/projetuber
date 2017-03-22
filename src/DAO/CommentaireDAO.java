package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.projet.model.Commentaire;

@Repository

public class CommentaireDAO implements DAO<Commentaire, String> {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commentaire> findAll() {
		
		return em.createQuery("FROM Commentaire", Commentaire.class).getResultList();
	}

	@Override
	public Commentaire find(String id) {
		
		return em.find(Commentaire.class, id);
		
		
	}

	@Override
	public Commentaire save(Commentaire commentaire) {
		
		return em.merge(commentaire)  ;
	}

	@Override
	public void delete(Commentaire commentaire) {
		em.remove(commentaire);
		
	}
	

}

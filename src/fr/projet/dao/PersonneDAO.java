package fr.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.projet.model.Personne;

@Repository
@Transactional
public class PersonneDAO extends IDAO<Personne> {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Personne find(int id) {
		return this.em.find(Personne.class, id);
	}

	@Override
	public List<Personne> findAll() {
		return this.em.createQuery("SELECT pers FROM Personne pers", Personne.class).getResultList();
	}

	@Override
	public Personne save(Personne object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Personne object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

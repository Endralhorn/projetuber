package fr.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fr.projet.model.Conducteur;

@Repository
@Transactional
public class ConducteurDAO extends IDAO<Conducteur>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Conducteur find(int id) {
		return this.em.find(Conducteur.class, id);
	}

	@Override
	public List<Conducteur> findAll() {
		return this.em.createQuery("SELECT cd FROM Conducteur cd", Conducteur.class).getResultList();
	
	}

	@Override
	public Conducteur save(Conducteur object) {		
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Conducteur object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

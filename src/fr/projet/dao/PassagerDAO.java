package fr.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fr.projet.model.Passager;

@Repository
@Transactional
public class PassagerDAO extends IDAO<Passager>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Passager find(int id) {
		return this.em.find(Passager.class, id);
	}

	@Override
	public List<Passager> findAll() {	
		return this.em.createQuery("SELECT p FROM Passager p", Passager.class).getResultList();
	}

	@Override
	public Passager save(Passager object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Passager object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

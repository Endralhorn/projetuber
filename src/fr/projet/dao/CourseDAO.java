package fr.projet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fr.projet.model.Course;

@Repository
@Transactional
public class CourseDAO extends IDAO<Course>{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Course find(int id) {
		return this.em.find(Course.class, id);
	}

	@Override
	public List<Course> findAll() {
		return this.em.createQuery("SELECT crs FROM Course crs", Course.class).getResultList();
	}

	@Override
	public Course save(Course object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Course object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}

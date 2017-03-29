package fr.projet.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.dao.ConducteurDAO;
import fr.projet.dao.CourseDAO;
import fr.projet.model.Conducteur;
import fr.projet.model.Course;
import fr.projet.model.Passager;

@RestController
@RequestMapping("/course")
public class CourseRestController {

	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private ConducteurDAO conducteurDAO;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Course> addCourse(@RequestBody Course course){
		course = this.courseDAO.save(course);
		
		return new ResponseEntity<Course>(course, HttpStatus.OK); 
	}
	
	
	
//	@RequestMapping(value="/{id}/conducteur/{idConducteur}/accepter", method=RequestMethod.PUT)
//	@ResponseBody
//	public ResponseEntity<Conducteur> accepterCommande(@PathVariable int id, @PathVariable int idConducteur) {
//		Conducteur myConducteur = this.conducteurDAO.find(idConducteur);
//		Course myCourse = this.courseDAO.find(id);
//		if (myCourse.getConducteur().getId_personne() != myConducteur.getId_personne())
//			return new ResponseEntity<Conducteur>(HttpStatus.FORBIDDEN);
//		
//		myCourse.setConducteur(myConducteur);
//		this.courseDAO.save(myCourse);
//		
//		return new ResponseEntity<Conducteur>(myConducteur, HttpStatus.OK);	
//		
//	}
//	
	
	
	
}

package fr.projet.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.dao.CommentaireDAO;
import fr.projet.dao.CourseDAO;
import fr.projet.dao.PassagerDAO;
import fr.projet.model.Commentaire;
import fr.projet.model.Course;
import fr.projet.model.Passager;

@RestController
@RequestMapping("/passager")
public class PassagerRestController {

	@Autowired 
	private PassagerDAO passagerDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private CommentaireDAO commentaireDAO;
	
	
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Passager> addPassager(@RequestBody Passager passager){
		passager = this.passagerDAO.save(passager);
		return new ResponseEntity<Passager>(passager, HttpStatus.OK); 
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Passager> afficherPassager(@RequestBody Passager passager){
		passager = this.passagerDAO.find(passager.getId_personne());
		return new ResponseEntity<Passager>(passager, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> savePassager(
			@RequestBody Passager passager,
			@PathVariable int id){
		passager.setId_personne(id);
		passager = this.passagerDAO.save(passager);
		
		return new ResponseEntity<Passager>(passager, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}/courses", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> coursesPassager(@PathVariable int id) {
		Passager myPassager= this.passagerDAO.find(id);
		
		return new ResponseEntity<List<Course>>(myPassager.getCourses(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}/course/valider/{idCourse}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> validerCourse(@PathVariable int id, @PathVariable int idCourse) {
		Passager myPassager= this.passagerDAO.find(id);
		Course myCourse = this.courseDAO.find(idCourse);
		if (myCourse.getPassager().getId_personne() != myPassager.getId_personne())
			return new ResponseEntity<Passager>(HttpStatus.FORBIDDEN);
		myCourse.setCour_validation(true);
		this.courseDAO.save(myCourse);
		
		return new ResponseEntity<Passager>(myPassager, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}/payer", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> payerCourse(@PathVariable int id, @RequestParam String email) {
		Passager myPassager= this.passagerDAO.find(id);
		myPassager.setMailPaypal(email);
		this.passagerDAO.save(myPassager);
		
		return new ResponseEntity<Passager>(myPassager, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/commentaire/commenter/{idCommentaire}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> commenterConducteur(@PathVariable int id, @PathVariable int idCommentaire, @RequestParam String com) {
		Passager myPassager= this.passagerDAO.find(id);
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		if (myCommentaire.getCourse().getPassager().getId_personne() != myPassager.getId_personne())
			return new ResponseEntity<Passager>(HttpStatus.FORBIDDEN);
		myCommentaire.setComm_commPassager(com);
		this.commentaireDAO.save(myCommentaire);
		
		return new ResponseEntity<Passager>(myPassager, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/commentaire/commenter/{idCommentaire}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> afficherCommentaire(@PathVariable int id, @PathVariable int idCommentaire){
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		
		return new ResponseEntity<String>(myCommentaire.getComm_commConducteur(), HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}/commentaire/noter/{idCommentaire}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> noterConducteur(@PathVariable int id, @PathVariable int idCommentaire, @RequestParam String com) {
		Passager myPassager= this.passagerDAO.find(id);
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		if (myCommentaire.getCourse().getPassager().getId_personne() != myPassager.getId_personne())
			return new ResponseEntity<Passager>(HttpStatus.FORBIDDEN);
		myCommentaire.setComm_noteConducteur(com);
		this.commentaireDAO.save(myCommentaire);
		return new ResponseEntity<Passager>(myPassager, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}/commentaire/noter/{idCommentaire}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> afficherNote(@PathVariable int id, @PathVariable int idCommentaire){
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		
		return new ResponseEntity<String>(myCommentaire.getComm_noteConducteur(), HttpStatus.OK); 
	}
	
	
	
}

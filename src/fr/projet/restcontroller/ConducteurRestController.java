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
import fr.projet.dao.ConducteurDAO;
import fr.projet.dao.CourseDAO;
import fr.projet.model.Commentaire;
import fr.projet.model.Conducteur;
import fr.projet.model.Course;



@RestController
@RequestMapping("/conducteur")
public class ConducteurRestController {

	@Autowired 
	private ConducteurDAO conducteurDAO; 
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private CommentaireDAO commentaireDAO;
	
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Conducteur> addConducteur(@RequestBody Conducteur conducteur){
		conducteur = this.conducteurDAO.save(conducteur);
		
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Conducteur> afficherConducteur(@RequestBody Conducteur conducteur){
		conducteur = this.conducteurDAO.find(conducteur.getId_personne());
		
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Conducteur> modifierConducteur(
			@RequestBody Conducteur conducteur,
			@PathVariable int id){
		conducteur.setId_personne(id);
		conducteur = this.conducteurDAO.save(conducteur);
		
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}/courses", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> coursesConducteur(@PathVariable int id) {
		Conducteur myConducteur= this.conducteurDAO.find(id);
		
		return new ResponseEntity<List<Course>>(myConducteur.getCourses(), HttpStatus.OK);
	}
	
	
//	@RequestMapping(value="/{id}/course/{idCourse}/valider", method=RequestMethod.PUT)
//	@ResponseBody
//	public ResponseEntity<Conducteur> validerCommande(@PathVariable int id, @PathVariable int idCourse) {
//		Conducteur myConducteur = this.conducteurDAO.find(id);
//		Course myCourse = this.courseDAO.find(idCourse);
//		
//		if (myCourse.getConducteur().getId_personne() != myConducteur.getId_personne())
//			return new ResponseEntity<Conducteur>(HttpStatus.FORBIDDEN);
//		
//		myCourse.setConducteur(myConducteur);
//		this.courseDAO.save(myCourse);
//		
//		return new ResponseEntity<Conducteur>(myConducteur, HttpStatus.OK);	
//		
//	}
	
	@RequestMapping(value="/{id}/commentaire/commenter/{idCommentaire}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Conducteur> commenterPassager(@PathVariable int id, @PathVariable int idCommentaire, @RequestParam String com) {
		Conducteur myConducteur= this.conducteurDAO.find(id);
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		if (myCommentaire.getCourse().getConducteur().getId_personne() != myConducteur.getId_personne())
			return new ResponseEntity<Conducteur>(HttpStatus.FORBIDDEN);
		myCommentaire.setComm_commPassager(com);
		this.commentaireDAO.save(myCommentaire);
		
		return new ResponseEntity<Conducteur>(myConducteur, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}/commentaire/commenter/{idCommentaire}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> afficherCommentaire(@PathVariable int id, @PathVariable int idCommentaire){
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		
		return new ResponseEntity<String>(myCommentaire.getComm_commPassager(), HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}/commentaire/noter/{idCommentaire}", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Conducteur> noterConducteur(@PathVariable int id, @PathVariable int idCommentaire, @RequestParam String com) {
		Conducteur myConducteur= this.conducteurDAO.find(id);
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		if (myCommentaire.getCourse().getConducteur().getId_personne() != myConducteur.getId_personne())
			return new ResponseEntity<Conducteur>(HttpStatus.FORBIDDEN);
		myCommentaire.setComm_notePassager(com);
		this.commentaireDAO.save(myCommentaire);
		
		return new ResponseEntity<Conducteur>(myConducteur, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}/commentaire/noter/{idCommentaire}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> afficherNote(@PathVariable int id, @PathVariable int idCommentaire){
		Commentaire myCommentaire = this.commentaireDAO.find(idCommentaire);
		
		return new ResponseEntity<String>(myCommentaire.getComm_notePassager(), HttpStatus.OK); 
	}
	
	
	
	
	
	
	
	
	
	
	
}

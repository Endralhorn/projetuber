package fr.projet.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.dao.PassagerDAO;
import fr.projet.model.Course;
import fr.projet.model.Passager;

@RestController
@RequestMapping("/passager")
public class PassagerRestController {

	@Autowired 
	private PassagerDAO passagerDAO;
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Passager> add(@RequestBody Passager passager){
		passager = this.passagerDAO.save(passager);
		return new ResponseEntity<Passager>(passager, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Passager> save(
			@RequestBody Passager passager,
			@PathVariable int id){
		passager.setId_personne(id);
		passager = this.passagerDAO.save(passager);
		
		return new ResponseEntity<Passager>(passager, HttpStatus.OK); 
	}
	
	
	@RequestMapping(value="/{id}/courses", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Course>> getCourses(@PathVariable int id) {
		Passager myPassager= this.passagerDAO.find(id);
		
		return new ResponseEntity<List<Course>>(myPassager.getCourses(), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

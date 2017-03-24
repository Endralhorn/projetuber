package fr.projet.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.dao.PassagerDAO;

@RestController
@RequestMapping("/passager")
public class PassagerRestController {

	@Autowired PassagerDAO passagerDAO;
	
	
	
}

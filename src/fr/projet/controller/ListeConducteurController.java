package fr.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ListeConducteurController {

	@RequestMapping(value = "/listeconducteur", method = RequestMethod.GET)
	public String login() {
		return "listeconducteur";

	}
}

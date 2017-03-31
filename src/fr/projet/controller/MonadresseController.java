package fr.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonadresseController {

	@RequestMapping(value = "/monadresse", method = RequestMethod.GET)
	public String login() {
		return "monadresse";

	}
}

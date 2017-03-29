
package fr.projet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DecoController {

	@RequestMapping(value = "/deco", method = RequestMethod.GET)
	public String login() {
		return "deco";

	}
}
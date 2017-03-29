package fr.projet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.projet.dao.ConducteurDAO;
import fr.projet.dao.PassagerDAO;
import fr.projet.model.Conducteur;
import fr.projet.model.Passager;

@Controller
public class LoginController {

	@Autowired
	private ConducteurDAO conducteurDAO;
	private PassagerDAO passagerDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "login";

	}

	@RequestMapping(value = "/inscriptionconducteur", method = RequestMethod.POST)
	public String inscriptionConducteur(Model model, @ModelAttribute("conducteur") Conducteur conducteur) {
		conducteur = this.conducteurDAO.save(conducteur);

		return "login";
	}

	@RequestMapping(value = "/inscriptionpassager", method = RequestMethod.POST)
	public String inscriptionPassager(Model model, @ModelAttribute("passager") Passager passager) {
		passager = this.passagerDAO.save(passager);

		return "login";
	}

	@RequestMapping(value = "/loginconducteur", method = RequestMethod.POST)
	public String log(Model model, @ModelAttribute Conducteur conducteur, BindingResult result) {
		conducteur = conducteurDAO.login(conducteur.getUsername(), conducteur.getMotPass());

		if (conducteur != null)

		{
			model.addAttribute("conducteur", conducteur);

			return "map";
		}

		else {
			return "login";
		}

	}

	@RequestMapping(value = "/loginpassager", method = RequestMethod.POST)
	public String log(Model model, @ModelAttribute Passager passager, BindingResult result) {
		passager = passagerDAO.login(passager.getUsername(), passager.getMotPass());

		if (passager != null)

		{
			model.addAttribute("passager", passager);

			return "map";
		}

		else {
			return "login";
		}

	}
}

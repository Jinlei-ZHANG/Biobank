package codejava.biostuffs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import codejava.biostuffs.dao.personaDAO;
import codejava.biostuffs.model.Persona;



public class PersonaController {
	@Autowired
	private personaDAO pDAO;
	
	@RequestMapping(value = "/savepersona", method = RequestMethod.GET)
	public ModelAndView personaInf(HttpServletRequest request) {
		Integer id = 2;
		Persona persona = pDAO.get(id);
		ModelAndView model = new ModelAndView("persona");
		model.addObject("PA", persona);

		return model;
	}
	
}

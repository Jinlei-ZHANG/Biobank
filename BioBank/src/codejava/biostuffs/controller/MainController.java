package codejava.biostuffs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	public ModelAndView menu(ModelAndView model) {
		model.setViewName("menu");
		return model;

	}

	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public ModelAndView retrievePersona(ModelAndView model) {
		model.setViewName("persona");
		return model;
	}

}

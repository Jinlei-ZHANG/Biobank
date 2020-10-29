package codejava.biostuffs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import codejava.biostuffs.dao.tissue_collectionsDAO;
import codejava.biostuffs.model.Tissue_collections;

@Controller
public class CollectionController {

	@Autowired
	private tissue_collectionsDAO tcollectionsDAO;

	@RequestMapping(value = "/collections")
	public ModelAndView listCollection(ModelAndView model) {
		List<Tissue_collections> listCollection = tcollectionsDAO.list();
		model.addObject("listCollection", listCollection);
		model.setViewName("collection_list");
		return model;

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newCollection(ModelAndView model) {
		Tissue_collections newCollection = new Tissue_collections();
		model.addObject("collection", newCollection);
		model.setViewName("collection_form");
		return model;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCollection(@ModelAttribute Tissue_collections tissue_collections) {
		if (tissue_collections.getId() == null) {
			tcollectionsDAO.save(tissue_collections);
		} else {
			tcollectionsDAO.update(tissue_collections);
		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCollection(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tissue_collections tissue_collections = tcollectionsDAO.get(id);
		ModelAndView model = new ModelAndView("collection_form");
		model.addObject("collection", tissue_collections);

		return model;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCollection(@RequestParam Integer id) {
		tcollectionsDAO.delete(id);
		return new ModelAndView("redirect:/");

	}

}

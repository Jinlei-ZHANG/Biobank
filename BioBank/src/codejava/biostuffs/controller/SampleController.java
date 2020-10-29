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

import codejava.biostuffs.dao.tissue_samplesDAO;
import codejava.biostuffs.model.Tissue_samples;

@Controller
public class SampleController {

	@Autowired
	private tissue_samplesDAO tsamplesDAO;

	@RequestMapping(value = "/all_samples", method = RequestMethod.GET)
	public ModelAndView allSamples(ModelAndView model) {
		List<Tissue_samples> listSample = tsamplesDAO.list();
		model.addObject("listSample", listSample);
		model.setViewName("all_samples");
		return model;
	}

	@RequestMapping(value = "/samples", method = RequestMethod.GET)
	public ModelAndView listSamples(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		List<Tissue_samples> tissue_samples = tsamplesDAO.getlist(id);
		ModelAndView model = new ModelAndView("samples_list");
		model.addObject("Samples", tissue_samples);
		return model;
	}

	@RequestMapping(value = "/sample_form")
	public ModelAndView sampleInf(ModelAndView model) {
		model.setViewName("sample_form");
		return model;
	}

	@RequestMapping(value = "/newsample", method = RequestMethod.GET)
	public ModelAndView newSample(ModelAndView model) {
		Tissue_samples newSample = new Tissue_samples();
		model.addObject("sample", newSample);
		model.setViewName("sample_form");
		return model;

	}

	@RequestMapping(value = "/savesample", method = RequestMethod.POST)
	public ModelAndView saveSample(@ModelAttribute Tissue_samples tissue_samples) {
		if (tissue_samples.getId() == null) {
			tsamplesDAO.save(tissue_samples);
		} else {
			tsamplesDAO.update(tissue_samples);
		}

		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editsample", method = RequestMethod.GET)
	public ModelAndView editSample(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Tissue_samples tissue_samples = tsamplesDAO.get(id);
		ModelAndView model = new ModelAndView("sample_form");
		model.addObject("sample", tissue_samples);
		return model;
	}

	@RequestMapping(value = "/deletesample", method = RequestMethod.GET)
	public ModelAndView deleteSample(@RequestParam Integer id) {
		tsamplesDAO.delete(id);
		return new ModelAndView("redirect:/");

	}
}

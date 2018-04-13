package org.wecancodeit.columbus.plantplanner.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.columbus.plantplanner.data.PlantRepository;

@Controller
public class PlantTemplateController {
	@Resource
	private PlantRepository plantRepo;

	@RequestMapping("/plant")
	public String showPlant(@RequestParam("id") Long plantId, Model model) {
		if (plantRepo.findOne(plantId) == null) {
			return "notFound";
		}
		model.addAttribute("plant", plantRepo.findOne(plantId));
		return "plant";
	}

//	@RequestMapping(path = "/plant/{id}", method = RequestMethod.GET)
//	public String showAnotherPlant(@PathVariable("id") Long plantId, Model model) {
//		if (plantRepo.findOne(plantId) == null) {
//			return "notFound";
//		}
//		model.addAttribute("plant", plantRepo.findOne(plantId));
//		return "partials/singlePlantViewPartial";
//	}
}

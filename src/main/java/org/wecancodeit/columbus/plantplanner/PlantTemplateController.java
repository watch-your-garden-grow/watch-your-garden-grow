package org.wecancodeit.columbus.plantplanner;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlantTemplateController {
	@Resource
	private PlantRepository plantRepo;

	@RequestMapping("/plant")
	public String showPlant(@RequestParam("id") Long plantId, Model model) {
		Plant selectedPlant = plantRepo.findOne(plantId);
		if (selectedPlant == null) {
			return "notFound";
		}
		model.addAttribute("plant", selectedPlant);
		return "plant";

	}

	@RequestMapping("/plant/{id}")
	public String showAnotherPlant(@PathVariable("id") Long plantId, Model model) {
		Plant selectedPlant = plantRepo.findOne(plantId);
		if (selectedPlant == null) {
			return "notFound";
		}
		model.addAttribute("plant", selectedPlant);
		return "plant";
	}
}

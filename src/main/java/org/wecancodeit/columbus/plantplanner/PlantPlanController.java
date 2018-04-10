package org.wecancodeit.columbus.plantplanner;

import java.util.Comparator;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlantPlanController {


	@Resource
	private PlantRepository plantRepository;

	@Resource
	private PlantPlanRepository plantPlanRepository;

	@Resource
	private PlantPlanItemRepository plantPlanItemRepository;

	@Resource
	private ZipCodeLocalityRepository zipCodeRepo;

	@ResponseBody
	@GetMapping(value = "/api/plantplan")
	public HttpEntity<PlantPlan> getNewPlantPlan() {
		PlantPlan newPlantPlan = plantPlanRepository.save(new PlantPlan());
		return new ResponseEntity<>(newPlantPlan, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/plantplan/{plantPlanId}")
	public HttpEntity<PlantPlan> getPlanContents(@PathVariable("plantPlanId") Long plantPlanId) {
		PlantPlan plantplan = plantPlanRepository.findOne(plantPlanId);
		return new ResponseEntity<>(plantplan, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(value = "/api/plantplan/{plantPlanId}/{plantId}")
	public HttpEntity<String> addPlantToPlan(@PathVariable(value = "plantPlanId") Long plantPlanId,
			@PathVariable(value = "plantId") Long plantId) {
		Plant plant = plantRepository.findOne(plantId);

		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);

		PlantPlanItem plantPlanItem = plantPlanItemRepository.findByPlantPlanIdAndPlantId(plantPlanId, plantId)
				.orElseGet(() -> plantPlanItemRepository.save(new PlantPlanItem(plant)));

		plantPlan = plantPlanRepository.save(plantPlan.addPlantPlanItem(plantPlanItem));

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping(value = "/plantplan/{plantPlanId}")
	public String presetPlantPlan(@PathVariable("plantPlanId") Long plantPlanId, Model model) {
		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);
		model.addAttribute("plantPlanItems" , plantPlan.getPlantPlanItems());	
		model.addAttribute("plantNameComp", Comparator.comparing(PlantPlanItem::getPlantName).reversed());
		return "plantplan";
	}
}

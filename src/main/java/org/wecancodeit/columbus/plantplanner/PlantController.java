package org.wecancodeit.columbus.plantplanner;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {

	@Resource
	private PlantRepository plantRepo;

	@RequestMapping("/plants")
	public Iterable<Plant> findPlants() {
		return plantRepo.findAll();
	}

}

package org.wecancodeit.columbus.plantplanner;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantRestController {
		
	@Resource
	private PlantRepository plantRepo;

	@Resource
	private ZoneRepository zoneRepo;

	@Resource
	private ZipCodeLocalityRepository zipCodeRepo;

	@RequestMapping("/plants")
	public Iterable<Plant> findPlants() {
		return plantRepo.findAll();
	}

	@RequestMapping("/plants/{id}")
	public Plant findPlant(@PathVariable(name = "id") long id) {
		if (plantRepo.findOne(id) == null) {
			throw new SomethingNotFoundException("Plant Not Found");
		}
		return plantRepo.findOne(id);
	}

	@RequestMapping("/zones")
	public Iterable<Zone> findZones() {
		return zoneRepo.findAll();
	}

	@RequestMapping("/zones/{id}")
	public Zone findZone(@PathVariable(name = "id") long id) {
		if (zoneRepo.findOne(id) == null) {
			throw new SomethingNotFoundException("Phz Not Found");
		}

		return zoneRepo.findOne(id);
	}

	@RequestMapping("/zone/{id}")
	public Iterable<Plant> findPlantsByZoneId(@PathVariable(name = "id") Long id) {
		return zoneRepo.findOne(id).getPlants();
	}

	public Iterable<Plant> findPlantsByZone(String zone) {
		return zoneRepo.findOneByZone(zone).getPlants();
	}

	@RequestMapping("/zipcode/{zipcode}")
	public String findPhzByZipcode(@PathVariable(name = "zipcode") String zipcode) {
		return zipCodeRepo.findZoneByZipCode(zipcode);
	}

	@RequestMapping("/plants/zipcode/{zipcode}")
	public Iterable<Plant> findPlantsByZipcode(@PathVariable(name = "zipcode") String zipcode) {
		String zoneName = zipCodeRepo.findZoneByZipCode(zipcode);
		if (zoneName == null) {
			throw new SomethingNotFoundException("Zipcode Not Found");
		}
		Zone targetZone = zoneRepo.findOneByZone(zoneName);
		if (targetZone == null) {
			throw new SomethingNotFoundException("Zone Not Found");
		}
		return targetZone.getPlants();
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class SomethingNotFoundException extends RuntimeException {
		private String errorMessage;

		public String getErrorMessage() {
			return errorMessage;
		}
		
		SomethingNotFoundException(String errorMessage) {
			this.errorMessage = errorMessage;			
		}
	}

	@ExceptionHandler(SomethingNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleSomethingNotFoundException(SomethingNotFoundException errorException) {
		return errorException.getErrorMessage();
	}
}

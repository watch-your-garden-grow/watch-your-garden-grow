package org.wecancodeit.columbus.plantplanner;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlantPopulator implements CommandLineRunner {

	@Resource
	PlantRepository plantRepo;

	@Resource
	ZoneRepository zoneRepo;

	private Zone createZone(String zoneName) {
		Zone z = new Zone(zoneName);
		return zoneRepo.save(z);
	}

	@Override
	public void run(String... args) throws Exception {

		Zone zone1 = createZone("Zone 6A");
		Zone zone2 = createZone("Zone 6B");
		Zone zone3 = createZone("Zone 5B");
		Zone zone4 = createZone("Zone 11A");

		plantRepo.save(new Plant("Beans", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Beets", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Broccoli", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Brussel Sprouts", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cabbage", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Carrots", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cauliflower", zone1, zone2, zone3));
		plantRepo.save(new Plant("Corn", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cucumber", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Kale", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Lettuce", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Onions", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peas", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peppers", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Spinach", zone1, zone2, zone3));
		plantRepo.save(new Plant("Squash", zone1, zone2, zone3));
		plantRepo.save(new Plant("Tomatoes", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Asparagus", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cantalope", zone1, zone2, zone3));
		plantRepo.save(new Plant("Eggplant", zone1, zone2, zone3));
		plantRepo.save(new Plant("Pumpkins", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Potatoes", zone1, zone2, zone3));
		plantRepo.save(new Plant("Watermelon", zone1, zone2, zone3));
		plantRepo.save(new Plant("Radishes", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Strawberries", zone1, zone2, zone3));
		plantRepo.save(new Plant("Zucchini", zone4));
		plantRepo.save(new Plant("Agave", zone4));
		plantRepo.save(new Plant("Avocado", zone4));
		plantRepo.save(new Plant("Banana", zone4));
		plantRepo.save(new Plant("Pineapple", zone4));
	}

}

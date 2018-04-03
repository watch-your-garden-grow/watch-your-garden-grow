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

		plantRepo.save(new Plant("Beans", "Plant 1-2 inches deep, in an area with full sun", "/images/beans.jpg", zone1,
				zone2, zone3, zone4));
		plantRepo.save(new Plant("Beets", "description", "/images/beets.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Broccoli", "description", "/images/broccoli.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(
				new Plant("Brussel Sprouts", "description", "/images/brussel-sprouts.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cabbage", "description", "/images/cabbage.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Carrots", "description", "/images/carrots.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cauliflower", "description", "/images/cauliflower.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Corn", "description", "/images/corn.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cucumber", "description", "/images/cucumber.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Kale", "description", "/images/kale.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Lettuce", "description", "/images/lettuce.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Onions", "description", "/images/onions.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peas", "description", "/images/peas.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peppers", "description", "/images/peppers.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Spinach", "description", "/images/spinach.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Squash", "description", "/images/squash.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Tomatoes", "description", "/images/tomatoes.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Asparagus", "description", "/images/asparagus.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cantaloupe", "description", "/images/cantaloupe.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Eggplant", "description", "/images/eggplant.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Pumpkins", "description", "/images/pumpkins.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Potatoes", "description", "/images/potatoes.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Watermelon", "description", "/images/watermelon.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Radishes", "description", "/images/radishes.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Strawberries", "description", "/images/strawberry.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Zucchini", "description", "/images/zucchini.jpg", zone4));
		plantRepo.save(new Plant("Agave", "description", "/images/agave.jpg", zone4));
		plantRepo.save(new Plant("Avocado", "description", "/images/avocado.jpg", zone4));
		plantRepo.save(new Plant("Banana", "description", "/images/banana.jpg", zone4));
		plantRepo.save(new Plant("Pineapple", "description", "/images/pineapple.jpg", zone4));
	}

}

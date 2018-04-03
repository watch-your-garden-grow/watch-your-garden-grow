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

		plantRepo.save(new Plant("Beans", "/images/beans.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Beets", "/images/beets.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Broccoli", "/images/broccoli.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Brussel Sprouts", "/images/brussel-sprouts.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cabbage", "/images/cabbage.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Carrots", "/images/carrots.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cauliflower", "/images/cauliflower.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Corn", "/images/corn.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Cucumber", "/images/cucumber.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Kale", "/images/kale.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Lettuce", "/images/lettuce.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Onions", "/images/onions.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peas", "/images/peas.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Peppers", "/images/peppers.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Spinach", "/images/spinach.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Squash", "/images/squash.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Tomatoes", "/images/tomatoes.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Asparagus", "/images/asparagus.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Cantaloupe", "/images/cantaloupe.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Eggplant", "/images/eggplant.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Pumpkins", "/images/pumpkins.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Potatoes", "/images/potatoes.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Watermelon", "/images/watermelon.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Radishes", "/images/radishes.jpg", zone1, zone2, zone3, zone4));
		plantRepo.save(new Plant("Strawberries", "/images/strawberry.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Zucchini", "/images/zucchini.jpg", zone4));
		plantRepo.save(new Plant("Agave", "/images/agave.jpg", zone4));
		plantRepo.save(new Plant("Avocado", "/images/avocado.jpg", zone4));
		plantRepo.save(new Plant("Banana", "/images/banana.jpg", zone4));
		plantRepo.save(new Plant("Pineapple", "/images/pineapple.jpg", zone4));
	}

}

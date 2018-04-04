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
		Zone zone5 = createZone("Zone 9B");
		Zone zone6 = createZone("Zone 1A");
		Zone zone7 = createZone("Zone 1B");
		Zone zone8 = createZone("Zone 2A");
		Zone zone9 = createZone("Zone 2B");
		Zone zone10 = createZone("Zone 3A");
		Zone zone11 = createZone("Zone 3B");

		plantRepo.save(new Plant("Artichoke",
				"Start indoors for 8 weeks, transplant outside seperating them from 5-6 feet apart.  Need full sunlight view",
				"/images/artichoke.jpg", zone5));
		plantRepo.save(new Plant("Beans", "Plant 1-2 inches deep in an area with full sun.", "/images/beans.jpg", zone1,
				zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Beets", "Plant 1/2 inch deep in area with atleast partial sunlight.",
				"/images/beets.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Broccoli", "Plant 2-4 inches deep in an area with full sunlight.",
				"/images/broccoli.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Brussel Sprouts", "Plant 1/2 inch deep in an area with full sun.",
				"/images/brussel-sprouts.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11));
		plantRepo.save(new Plant("Cabbage", "Plant in full sun.  12 to 24 inches apart from each other.",
				"/images/cabbage.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Celery",
				"Start indoors for 8 weeks, transplant outside 1/4 inch deep, 10-12 inches apart.  Need partial sunlight view",
				"/images/celery.jpg", zone5, zone10, zone11));
		plantRepo.save(new Plant("Carrots", "Plant 3 to 4 inches apart with full sun view.", "/images/carrots.jpg",
				zone1, zone2, zone3));
		plantRepo.save(new Plant("Cauliflower", "Plant 18-24 inches apart.  Needs at least 6 hours of sunlight.",
				"/images/cauliflower.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Corn", "Plant 1 inch deep, 4-6 inches apart.  Needs full sun view.",
				"/images/corn.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Cucumber", "Plant 6-8 inches into the soil.  Needs full sun view.",
				"/images/cucumber.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Chard", "Plant 1 inch deep, 2 inches apart.  Needs full sun view.",
				"/images/chard.jpg", zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Collard Greens", "Plant 1/2 inch deep, 8-12 inches apart.  Need full sunlight view",
				"/images/collard-greens.jpg", zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Kale", "Plant 1/2 inch deep, seperate by 8-12 inches.  Needs full sun view.",
				"/images/kale.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Lettuce", "Plant 1/2 inch deep, 12-15 inches apart.  Needs partial sunlight.",
				"/images/lettuce.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Leek", "Plant 6 inches deep, 10-12 inches apart.  Need full sunlight",
				"/images/leek.jpg", zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Onions", "Plant 1 inch deep, 4-5 inches apart.  Needs full sun view.",
				"/images/onions.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Peas", "Plant 1 inch deep, 2 inches apart.  Needs a partial view of the sun.",
				"/images/peas.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Peppers",
				" Needs soil temperatures of at least 65F, plant 18-24 inches apart.  Needs full sunlight.",
				"/images/peppers.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Spinach", "Plant to 1/2 inch deep.  Needs full sunlight.", "/images/spinach.jpg",
				zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Squash", "Plant 1 inche deep, 2 to 3 feet apart.  Needs full sunlight. ",
				"/images/squash.jpg", zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Tomatoes",
				"Start in pots, transplant with stakes to ground tilled to one foot in depth.  Needs at least 6 hours of sunlight.",
				"/images/tomatoes.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Asparagus",
				"Dig trench 6-12 inches deep, and six inches wide.  Plant crowns 15-18 inches apart.  Needs full sunlight.",
				"/images/asparagus.jpg", zone1, zone2, zone3));
		plantRepo
				.save(new Plant("Cantaloupe", "Plant 1 inch deep, and about 18 inches apart.  Build onto small mounds.",
						"/images/cantaloupe.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Eggplant", "Plant 24-30 inches apart.  Need full sunlight.", "/images/eggplant.jpg",
				zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Pumpkins",
				"Plant 1 inch deep, 6-8 feet apart.  Does really well on a hill facing the sun.",
				"/images/pumpkins.jpg", zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Potatoes",
				"Dig trenches 6 inches wide, and 8 inches deep.  Plant the potatoes every 6 inches, then cover with 3-4 inches of soil.  Needs full sunlight.",
				"/images/potatoes.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Watermelon",
				"Grow well on hills facing the sun.  Plant at least 2-6 feet apart from each other.",
				"/images/watermelon.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Radishes", "Plant 1/2 inch deep, 12 inches apart.  Need full sunlight.",
				"/images/radishes.jpg", zone1, zone2, zone3, zone4, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Strawberries",
				"Plant deep enough, and spaced out enough so that root system can spread out.  Needs at least 6 hours of sunlight daily.",
				"/images/strawberry.jpg", zone1, zone2, zone3));
		plantRepo.save(new Plant("Zucchini", "Plant 1 inche deep, 2 to 3 feet apart.  Needs full sunlight. ",
				"/images/zucchini.jpg", zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11));
		plantRepo.save(new Plant("Agave", "Needs to planted to a depth of 12 inches, needs a full view of the sun.",
				"/images/agave.jpg", zone4));
		plantRepo.save(new Plant("Avocado",
				"Dig hole with a depth of atleast 12 inches.  When the tree starts to sprout stake it to help facilitate growth.",
				"/images/avocado.jpg", zone4));
		plantRepo.save(new Plant("Banana",
				"Plant with a depth of at least 6 inches.  Needs to be blocked from the wind if possible.",
				"/images/banana.jpg", zone4));
		plantRepo.save(new Plant("Pineapple",
				"Start in a pot, let grow for 2-3 months before transplanting outside to allow roots to grow.",
				"/images/pineapple.jpg", zone4));
	}

}

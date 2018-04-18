package org.wecancodeit.columbus.plantplanner.data;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.columbus.plantplanner.models.Plant;
import org.wecancodeit.columbus.plantplanner.models.Zone;

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

		Zone zone1 = createZone("6a");
		Zone zone2 = createZone("6b");
		Zone zone3 = createZone("5b");
		Zone zone4 = createZone("11a");
		Zone zone5 = createZone("9b");
		Zone zone6 = createZone("1a");
		Zone zone7 = createZone("1b");
		Zone zone8 = createZone("2a");
		Zone zone9 = createZone("2b");
		Zone zone10 = createZone("3a");
		Zone zone11 = createZone("3b");
		Zone zone12 = createZone("4a");
		Zone zone13 = createZone("4b");
		Zone zone14 = createZone("5a");
		Zone zone15 = createZone("7a");
		Zone zone16 = createZone("7b");
		Zone zone17 = createZone("8a");
		Zone zone18 = createZone("8b");
		Zone zone19 = createZone("9a");
		Zone zone20 = createZone("10a");
		Zone zone21 = createZone("10b");
		Zone zone22 = createZone("11b");

		plantRepo.save(new Plant("Artichoke",
				"Start indoors for 8 weeks, transplant outside seperating them from 5-6 feet apart.  Need full sunlight view",
				"/images/artichoke.jpg", 12, zone5, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Beans", "Plant 1-2 inches deep in an area with full sun.", "/images/beans.jpg", 14,
				zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13, zone14,
				zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Beets", "Plant 1/2 inch deep in area with atleast partial sunlight.",
				"/images/beets.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Broccoli", "Plant 2-4 inches deep in an area with full sunlight.",
				"/images/broccoli.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Brussel Sprouts", "Plant 1/2 inch deep in an area with full sun.",
				"/images/brussel-sprouts.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Bristlecone Pine",
				"One of the more unique looking pines, and state Tree of Nevada, grows in 9A temperates",
				"/images/bristlecone.jpg", 1, zone19));
		plantRepo.save(new Plant("Buckeye Tree",
				"The state tree of Ohio, and our unique plant that only populates in zone 6A.", "/images/buckeye.jpg",
				1, zone1));
		plantRepo.save(new Plant("Bur Oak", "State tree of North Dakota, and a great tree for zone 3A.",
				"/images/bur-oak.jpg", 1, zone10));
		plantRepo.save(new Plant("Cabbage", "Plant in full sun.  12 to 24 inches apart from each other.",
				"/images/cabbage.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Candlenut tree",
				"Tropical tree, and the offical state tree of Hawaii, grows quite well in zone 11B",
				"/images/candlenut.jpg", 1, zone22));
		plantRepo.save(new Plant("Celery",
				"Start indoors for 8 weeks, transplant outside 1/4 inch deep, 10-12 inches apart.  Need partial sunlight view",
				"/images/celery.jpg", 1, zone5, zone10, zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18,
				zone19, zone20, zone21));
		plantRepo.save(new Plant("Carrots", "Plant 3 to 4 inches apart with full sun view.", "/images/carrots.jpg", 1,
				zone1, zone2, zone3, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21));
		plantRepo.save(new Plant("Cauliflower", "Plant 18-24 inches apart.  Needs at least 6 hours of sunlight.",
				"/images/cauliflower.jpg", 1, zone1, zone2, zone3, zone22));
		plantRepo.save(new Plant("Corn", "Plant 1 inch deep, 4-6 inches apart.  Needs full sun view.",
				"/images/corn.jpg", 14, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Cucumber", "Plant 6-8 inches into the soil.  Needs full sun view.",
				"/images/cucumber.jpg", 14, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Chard", "Plant 1 inch deep, 2 inches apart.  Needs full sun view.",
				"/images/chard.jpg", 1, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13, zone14,
				zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Collard Greens", "Plant 1/2 inch deep, 8-12 inches apart.  Need full sunlight view",
				"/images/collard-greens.jpg", 1, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13,
				zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Douglas Fir",
				"One of the most popular choices for Christmas trees, and grows extremely well in zone 2B",
				"/images/douglas-fir.jpg", 1, zone9));
		plantRepo.save(new Plant("Eastern Redbud", "Tree has a vibrant color, and can commonly be found in zone 10B",
				"/images/redbud.jpg", 1, zone21));
		plantRepo.save(new Plant("Flowering Dogwood",
				"State tree of Virginia, definitely an iconic tree in full bloom, does well in zone 7A.",
				"/images/dogwood.jpg", 1, zone15));
		plantRepo.save(new Plant("Giant Sequoia",
				"Maybe the most iconic tree of California, and also the state tree.  Can be found in zone 10A.",
				"/images/sequoia.jpg", 1, zone20));
		plantRepo.save(new Plant("Kale", "Plant 1/2 inch deep, seperate by 8-12 inches.  Needs full sun view.",
				"/images/kale.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Lettuce", "Plant 1/2 inch deep, 12-15 inches apart.  Needs partial sunlight.",
				"/images/lettuce.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Leek", "Plant 6 inches deep, 10-12 inches apart.  Need full sunlight",
				"/images/leek.jpg", 1, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13, zone14,
				zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Lindens",
				"Tree that is commonly called a lime tree, yet has no lime fruit.  Grows in zone 4A.",
				"/images/lindens.jpg", 1, zone12));
		plantRepo.save(new Plant("Onions", "Plant 1 inch deep, 4-5 inches apart.  Needs full sun view.",
				"/images/onions.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(
				new Plant("Palm Tree", "One of the staples of the warm temperates, and our choice to showcase zone 9B",
						"/images/palmtree.jpg", 1, zone5));
		plantRepo.save(new Plant("Oak Tree",
				"One of the great building woods, the oak tree is a great example of a zone 8B tree.",
				"/images/oak.jpg", 1, zone18));
		plantRepo.save(new Plant("Peas", "Plant 1 inch deep, 2 inches apart.  Needs a partial view of the sun.",
				"/images/peas.jpg", 1, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Pecan Tree",
				"State tree of Texas, and the provider of delicious pecans, does great in Zone 8A", "/images/pecan.jpg",
				1, zone17));
		plantRepo.save(new Plant("Peppers",
				" Needs soil temperatures of at least 65F, plant 18-24 inches apart.  Needs full sunlight.",
				"/images/peppers.jpg", 20, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Picea Mariana", "One of the more interesting pine tree examples from zone 2A.",
				"/images/picea-mariana.jpg", 1, zone8));
		plantRepo.save(new Plant("Northern Red Oak", "One of the staples of zone 5B, and has beautiful foliage",
				"/images/redoak.jpg", 1, zone3));
		plantRepo.save(new Plant("Western Red Cedar",
				"Beautiful tree, and commonly used for building purposes, grows well in zone 4B",
				"/images/red-cedar.jpg", 1, zone13));
		plantRepo.save(new Plant("Serviceberry Tree",
				"One of the uniquely Utah trees.  Which just happens to reside in zone 7B", "/images/serviceberry.jpg",
				1, zone16));
		plantRepo.save(new Plant("Sitka Spruce", "The state tree of Alaska, and a mammoth example of trees in 1B",
				"/images/sitka-spruce", 1, zone7));
		plantRepo.save(new Plant("Spinach", "Plant to 1/2 inch deep.  Needs full sunlight.", "/images/spinach.jpg", 1,
				zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13, zone14, zone15,
				zone16, zone17, zone18, zone19, zone22));
		plantRepo.save(new Plant("Squash", "Plant 1 inch deep, 2 to 3 feet apart.  Needs full sunlight. ",
				"/images/squash.jpg", 1, zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12,
				zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo
				.save(new Plant("Sugar Maple", "State tree of Vermont, has beautiful foliage, can be found in zone 5A.",
						"/images/sugar-maple.jpg", 1, zone14));
		plantRepo.save(new Plant("Tomatoes",
				"Start in pots, transplant with stakes to ground tilled to one foot in depth.  Needs at least 6 hours of sunlight.",
				"/images/tomatoes.jpg", 14, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Tulip Tree", "One of the trademark trees of Kentucky, which is mostly zone 6B.",
				"/images/tulip.jpg", 1, zone2));
		plantRepo.save(new Plant("Asparagus",
				"Dig trench 6-12 inches deep, and six inches wide.  Plant crowns 15-18 inches apart.  Needs full sunlight.",
				"/images/asparagus.jpg", 14, zone1, zone2, zone3, zone5, zone12, zone13, zone14, zone15, zone16, zone17,
				zone18, zone19));
		plantRepo
				.save(new Plant("Cantaloupe", "Plant 1 inch deep, and about 18 inches apart.  Build onto small mounds.",
						"/images/cantaloupe.jpg", 20, zone1, zone2, zone3));
		plantRepo.save(new Plant("Eggplant", "Plant 24-30 inches apart.  Need full sunlight.", "/images/eggplant.jpg",
				14, zone1, zone2, zone3, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13, zone14,
				zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Pumpkins",
				"Plant 1 inch deep, 6-8 feet apart.  Does really well on a hill facing the sun.",
				"/images/pumpkins.jpg", 20, zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9, zone10,
				zone11, zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Potatoes",
				"Dig trenches 6 inches wide, and 8 inches deep.  Plant the potatoes every 6 inches, then cover with 3-4 inches of soil.  Needs full sunlight.",
				"/images/potatoes.jpg", 1, zone1, zone2, zone3, zone6, zone7, zone8, zone9, zone10, zone11, zone12,
				zone13, zone14, zone15, zone16));
		plantRepo.save(new Plant("Quaking Aspen", "State tree of Utah, and a tree that excels in Zone 3B",
				"/images/quaking-aspen.jpg", 1, zone11));
		plantRepo.save(new Plant("Watermelon",
				"Grows well on hills facing the sun.  Plant at least 2-6 feet apart from each other.",
				"/images/watermelon.jpg", 30, zone1, zone2, zone3));
		plantRepo.save(new Plant("White Spruce",
				"The White Spruce is the tree you think of when you think of cold, grows well in Zone 1A",
				"/images/white-spruce.jpg", 1, zone6));
		plantRepo.save(new Plant("Radishes", "Plant 1/2 inch deep, 12 inches apart.  Need full sunlight.",
				"/images/radishes.jpg", 1, zone1, zone2, zone3, zone4, zone6, zone7, zone8, zone9, zone10, zone11,
				zone12, zone13, zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Strawberries",
				"Plant deep enough, and spaced out enough so that root system can spread out.  Needs at least 6 hours of sunlight daily.",
				"/images/strawberries.jpg", 30, zone1, zone2, zone3, zone5, zone12, zone13, zone14, zone15, zone16,
				zone17, zone18, zone19, zone20, zone21));
		plantRepo.save(new Plant("Zucchini", "Plant 1 inch deep, 2 to 3 feet apart.  Needs full sunlight. ",
				"/images/zucchini.jpg", 1, zone4, zone5, zone6, zone7, zone8, zone9, zone10, zone11, zone12, zone13,
				zone14, zone15, zone16, zone17, zone18, zone19, zone20, zone21, zone22));
		plantRepo.save(new Plant("Agave", "Needs to planted to a depth of 12 inches, needs a full view of the sun.",
				"/images/agave.jpg", 1, zone4));
		plantRepo.save(new Plant("Avocado",
				"Dig hole with a depth of atleast 12 inches.  When the tree starts to sprout stake it to help facilitate growth.",
				"/images/avocado.jpg", 1, zone4));
		plantRepo.save(new Plant("Banana",
				"Plant with a depth of at least 6 inches.  Needs to be blocked from the wind if possible.",
				"/images/banana.jpg", 1, zone4));
		plantRepo.save(new Plant("Pineapple",
				"Start in a pot, let grow for 2-3 months before transplanting outside to allow roots to grow.",
				"/images/pineapple.jpg", 1, zone4));
	}

}

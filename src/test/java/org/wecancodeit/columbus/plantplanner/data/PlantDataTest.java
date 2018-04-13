package org.wecancodeit.columbus.plantplanner.data;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.columbus.plantplanner.data.PlantRepository;
import org.wecancodeit.columbus.plantplanner.data.ZoneRepository;
import org.wecancodeit.columbus.plantplanner.models.Plant;
import org.wecancodeit.columbus.plantplanner.models.Zone;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PlantDataTest {

	@Resource
	private PlantRepository plantRepo;

	@Resource
	private ZoneRepository zoneRepo;

	@Resource
	private TestEntityManager entityManager;

	@Test
	public void shouldCreatePlant() {
		Plant plant = new Plant("Beans", "description", "image", 14);
		plant = plantRepo.save(plant);
		long plantId = plant.getId();

		entityManager.flush();
		entityManager.clear();

		plant = plantRepo.findOne(plantId);
		assertThat(plant.getName(), is("Beans"));
	}

	@Test
	public void shouldSaveAndLoadZone() {
		Zone zone = zoneRepo.save(new Zone("zoneName"));
		long zoneId = zone.getId();

		entityManager.flush();
		entityManager.clear();

		zone = zoneRepo.findOne(zoneId);
		assertThat(zone.getZoneName(), is("zoneName"));
	}

	@Test
	public void shouldEstablishAPlantToZoneRelationship() {
		Zone sixA = zoneRepo.save(new Zone("6A"));
		Zone sixB = zoneRepo.save(new Zone("6B"));

		Plant plant = new Plant("", "description", "", 14, sixA, sixB);
		plant = plantRepo.save(plant);
		long plantName = plant.getId();

		plant = plantRepo.findOne(plantName);
		assertThat(plant.getZones(), containsInAnyOrder(sixA, sixB));
	}

	@Test
	public void shouldEstablishAZoneToPlantRelationship() {
		Zone zone = zoneRepo.save(new Zone("6A"));
		long zoneId = zone.getId();

		Plant beans = new Plant("beans", "description", "image", 14, zone);
		beans = plantRepo.save(beans);

		Plant corn = new Plant("corn", "description", "image", 14, zone);
		corn = plantRepo.save(corn);

		entityManager.flush();
		entityManager.clear();

		zone = zoneRepo.findOne(zoneId);
		assertThat(zone.getPlants(), containsInAnyOrder(beans, corn));
	}

	@Test
	public void shouldReturnPlantNameDescriptionAndImage() {
		Zone zone = zoneRepo.save(new Zone("6A"));

		Plant underTest = new Plant("name", "description", "image", 14, zone);
		String check = underTest.getName();
		String check2 = underTest.getDescription();
		String check3 = underTest.getImage();

		assertEquals(check, "name");
		assertEquals(check2, "description");
		assertEquals(check3, "image");
	}

	@Test
	public void shouldReturnPlantSowDate() {
		Zone zone = zoneRepo.save(new Zone("6A"));

		Plant underTest = new Plant("name", "description", "image", 14, zone);
		int check = underTest.daysSinceLastFrost();

		assertEquals(check, 14);

	}
}

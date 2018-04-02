package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		Plant plant = new Plant("Beans");
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

		Plant plant = new Plant("", sixA, sixB);
		plant = plantRepo.save(plant);
		long plantName = plant.getId();

		plant = plantRepo.findOne(plantName);
		assertThat(plant.getZones(), containsInAnyOrder(sixA, sixB));
	}

}

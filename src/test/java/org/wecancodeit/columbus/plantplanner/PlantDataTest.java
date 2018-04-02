package org.wecancodeit.columbus.plantplanner;

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

}

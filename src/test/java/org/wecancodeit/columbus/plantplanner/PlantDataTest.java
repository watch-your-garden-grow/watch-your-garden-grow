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
	private TestEntityManager entityManager;

	@Test
	public void ShouldCreatePlant() {
		Plant plant = new Plant("Beans");
		plant = plantRepo.save(plant);
		long plantId = plant.getId();

		entityManager.flush();
		entityManager.clear();

		plant = plantRepo.findOne(plantId);
		assertThat(plant.getName(), is("Beans"));

	}

}

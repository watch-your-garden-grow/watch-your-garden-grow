package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.wecancodeit.columbus.plantplanner.PlantController.SomethingNotFoundException;

public class PlantControllerTest {

	@InjectMocks
	private PlantController underTest;

	@Mock
	private Plant plant;

	@Mock
	private PlantRepository plantRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrievePlants() {
		when(plantRepo.findAll()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlants();
		assertThat(result, contains(any(Plant.class)));
	}

	@Test
	public void shouldGetPlantsFromDatabase() {
		when(plantRepo.findAll()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlants();
		assertThat(result, contains(plant));
	}

	@Test
	public void shouldReturnIndividualPlantFromDatabase() {
		when(plantRepo.findOne(3L)).thenReturn(plant);
		Plant result = underTest.findPlant(3L);
		assertThat(result, is(plant));
	}
	
	@Test (expected = SomethingNotFoundException.class)
	public void shouldReturnNotFoundExceptionForBadProductId() {
		long invalidProductId = 42L;
		underTest.findPlant(invalidProductId);
	}
}

package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
}

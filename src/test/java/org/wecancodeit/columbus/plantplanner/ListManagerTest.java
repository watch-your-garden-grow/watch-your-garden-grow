package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListManagerTest {

	private ListManager underTest = new ListManager();
	private PlantDouble testPlant = new PlantDouble("6a", "Tomato");
	private PlantDouble testPlant2 = new PlantDouble("10a", "Pineapple");

	@Test
	public void shouldReturnTrueIfPlantIsInAGivenZone() {
		boolean result = underTest.checkPlantViability("6a", testPlant);

		assertThat(result, is(true));
	}

	@Test
	public void shouldReturnFalseIfPlantIsNotInAGivenZone() {
		boolean result = underTest.checkPlantViability("6a", testPlant2);

		assertThat(result, is(false));
	}

	@Test
	public void shouldCheckForZone6aAndReturnListOfTomatoAndCorn() {
		PlantDouble testPlant3 = new PlantDouble("6a", "Corn");
		List<PlantDouble> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant);
		plantDoubles.add(testPlant2);
		plantDoubles.add(testPlant3);

		List<PlantDouble> result = underTest.returnListOfViablePlants(plantDoubles, "6a");

		assertThat(result, containsInAnyOrder(testPlant, testPlant3));
	}
	
	@Test
	public void shouldCheckForZone1AndReturnEmptyList() {
		
	}
}
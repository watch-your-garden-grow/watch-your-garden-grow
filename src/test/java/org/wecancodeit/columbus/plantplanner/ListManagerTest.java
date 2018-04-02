package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ListManagerTest {

	@Test
	public void shouldReturnTrueIfPlantIsInAGivenZone() {
		ListManager underTest = new ListManager();
		PlantDouble testPlant = new PlantDouble("6a", "Tomato");

		boolean result = underTest.checkPlantViability("6a", testPlant);

		assertThat(result, is(true));
	}

	@Test
	public void shouldReturnFalseIfPlantIsNotInAGivenZone() {
		ListManager underTest = new ListManager();
		PlantDouble testPlant2 = new PlantDouble("10a", "Pineapple");

		boolean result = underTest.checkPlantViability("6a", testPlant2);

		assertThat(result, is(false));
	}
}
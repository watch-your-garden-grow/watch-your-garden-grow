package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

public class ListManagerTest {

	private Zone sixA = new Zone("6a");
	private Zone sixB = new Zone("6b");
	private Zone fiveA = new Zone("5a");
	private Zone tenA = new Zone("10a");

	private ListManager underTest = new ListManager();

	private Plant testPlant3 = new Plant("Corn", "", "", 0, sixA, sixB);
	private Plant testPlant = new Plant("Tomato", "", "", 0, sixA);
	private Plant testPlant2 = new Plant("Pineapple", "", "", 0, tenA);

	@Test
	public void shouldReturnTrueIfPlantIsInAGivenZone() {
		boolean result = underTest.checkPlantViability(sixA, testPlant);

		assertThat(result, is(true));
	}

	@Test
	public void shouldReturnFalseIfPlantIsNotInAGivenZone() {
		boolean result = underTest.checkPlantViability(sixA, testPlant2);

		assertThat(result, is(false));
	}

	@Test
	public void shouldCheckForZone6aAndReturnListOfTomatoAndCorn() {
		List<Plant> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant);
		plantDoubles.add(testPlant2);
		plantDoubles.add(testPlant3);

		List<Plant> result = underTest.returnListOfViablePlants(plantDoubles, sixA);

		assertThat(result, containsInAnyOrder(testPlant, testPlant3));
	}

	@Test
	public void shouldCheckForZoneFiveAAndReturnEmptyList() {
		List<Plant> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant);
		plantDoubles.add(testPlant2);
		plantDoubles.add(testPlant3);

		List<Plant> result = underTest.returnListOfViablePlants(plantDoubles, fiveA);

		assertThat(result, IsEmptyCollection.empty());
	}

	@Test
	public void shouldOnlyReturnPlantsWithSpecificHardinessZone() {
		Plant testPlant4 = new Plant("Tomatoes", "", "", 0, sixA, fiveA);
		Plant testPlant5 = new Plant("Peas", "", "", 0, sixA);
		Plant testPlant6 = new Plant("Grapes", "", "", 0, sixA, sixB);

		List<Plant> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant3);
		plantDoubles.add(testPlant4);
		plantDoubles.add(testPlant5);
		plantDoubles.add(testPlant6);

		List<Plant> result = underTest.returnListOfViablePlants(plantDoubles, sixB);

		assertThat(result, containsInAnyOrder(testPlant3, testPlant6));
	}
}
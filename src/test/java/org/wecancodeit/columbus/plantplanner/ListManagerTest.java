package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

public class ListManagerTest {

	private HardinessZoneDouble sixA = new HardinessZoneDouble("6a");
	private HardinessZoneDouble sixB = new HardinessZoneDouble("6b");
	private HardinessZoneDouble fiveA = new HardinessZoneDouble("5a");
	private HardinessZoneDouble tenA = new HardinessZoneDouble("10a");

	private ListManager underTest = new ListManager();

	private PlantDouble testPlant3 = new PlantDouble("Corn", sixA, sixB);
	private PlantDouble testPlant = new PlantDouble("Tomato", sixA);
	private PlantDouble testPlant2 = new PlantDouble("Pineapple", tenA);

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
		List<PlantDouble> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant);
		plantDoubles.add(testPlant2);
		plantDoubles.add(testPlant3);

		List<PlantDouble> result = underTest.returnListOfViablePlants(plantDoubles, sixA);

		assertThat(result, containsInAnyOrder(testPlant, testPlant3));
	}

	@Test
	public void shouldCheckForZoneFiveAAndReturnEmptyList() {
		List<PlantDouble> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant);
		plantDoubles.add(testPlant2);
		plantDoubles.add(testPlant3);

		List<PlantDouble> result = underTest.returnListOfViablePlants(plantDoubles, fiveA);

		assertThat(result, IsEmptyCollection.empty());
	}

	@Test
	public void shouldOnlyReturnPlantsWithSpecificHardinessZone() {
		PlantDouble testPlant4 = new PlantDouble("Tomatoes", sixA, fiveA);
		PlantDouble testPlant5 = new PlantDouble("Peas", sixA);
		PlantDouble testPlant6 = new PlantDouble("Grapes", sixA, sixB);
		
		List<PlantDouble> plantDoubles = new ArrayList<>();

		plantDoubles.add(testPlant3);
		plantDoubles.add(testPlant4);
		plantDoubles.add(testPlant5);
		plantDoubles.add(testPlant6);

		List<PlantDouble> result = underTest.returnListOfViablePlants(plantDoubles, sixB);

		assertThat(result, containsInAnyOrder(testPlant3, testPlant6));
	}
}
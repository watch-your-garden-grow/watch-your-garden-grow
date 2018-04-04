package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PlantDoubleTest {

	@Test
	public void plantShouldBeAbleToHaveMultipleHardinessZones() {
		Zone six = new Zone("6");
		Zone five = new Zone("5");

		Plant testPlant4 = new Plant("Lettuce", "", "", six, five);

		assertThat(testPlant4.getZones(), containsInAnyOrder(six, five));
	}
}

package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PlantDoubleTest {

	@Test
	public void plantShouldBeAbleToHaveMultipleHardinessZones() {
		HardinessZoneDouble six = new HardinessZoneDouble("6");
		HardinessZoneDouble five = new HardinessZoneDouble("5");

		PlantDouble testPlant4 = new PlantDouble("Lettuce", six, five);

		assertThat(testPlant4.getZones(), containsInAnyOrder(six, five));
	}

}

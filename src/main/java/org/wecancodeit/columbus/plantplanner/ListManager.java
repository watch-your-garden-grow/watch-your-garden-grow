package org.wecancodeit.columbus.plantplanner;

import java.util.ArrayList;
import java.util.List;

public class ListManager {

	public boolean checkPlantViability(Zone checkedZone, Plant checkedPlant) {
		for (Zone plantZone : checkedPlant.getZones()) {
			if (checkedZone == plantZone) {
				return true;
			}
		}
		return false;
	}

	public List<Plant> returnListOfViablePlants(List<Plant> plantsToTest, Zone plantHardinessZone) {
		List<Plant> selectedPlants = new ArrayList<>();
		for (Plant plant : plantsToTest) {
			if (checkPlantViability(plantHardinessZone, plant)) {
				selectedPlants.add(plant);
			}
		}
		return selectedPlants;
	}

}

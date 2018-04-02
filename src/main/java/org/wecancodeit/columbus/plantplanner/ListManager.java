package org.wecancodeit.columbus.plantplanner;

import java.util.ArrayList;
import java.util.List;

public class ListManager {

	public boolean checkPlantViability(HardinessZoneDouble checkedZone, PlantDouble checkedPlant) {
		for (HardinessZoneDouble plantZone : checkedPlant.getZones()) {
			if (checkedZone == plantZone) {
				return true;
			}
		}
		return false;
	}

	public List<PlantDouble> returnListOfViablePlants(List<PlantDouble> plantsToTest,
			HardinessZoneDouble plantHardinessZone) {
		List<PlantDouble> selectedPlants = new ArrayList<>();
		for (PlantDouble plant : plantsToTest) {
			if (checkPlantViability(plantHardinessZone, plant)) {
				selectedPlants.add(plant);
			}
		}
		return selectedPlants;
	}

}

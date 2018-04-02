package org.wecancodeit.columbus.plantplanner;

import java.util.ArrayList;
import java.util.List;

public class ListManager {

	public boolean checkPlantViability(String checkedZone, PlantDouble checkedPlant) {
		return checkedZone == checkedPlant.getZone();
	}

	public List<PlantDouble> returnListOfViablePlants(List<PlantDouble> plantsToTest, String plantHardinessZone) {
		List<PlantDouble> selectedPlants = new ArrayList<>();
		for (PlantDouble plant : plantsToTest) {
			if (checkPlantViability(plantHardinessZone, plant)) {
				selectedPlants.add(plant);
			}
		}
		return selectedPlants;
	}

}

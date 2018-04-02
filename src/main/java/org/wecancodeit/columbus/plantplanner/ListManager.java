package org.wecancodeit.columbus.plantplanner;

public class ListManager {

	public boolean checkPlantViability(String checkedZone, PlantDouble checkedPlant) {
		return checkedZone == checkedPlant.getZone();
	}

}

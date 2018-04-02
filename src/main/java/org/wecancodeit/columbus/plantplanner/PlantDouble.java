package org.wecancodeit.columbus.plantplanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PlantDouble {

	private String zone;
	private String name;
	private List<HardinessZoneDouble> hardinessZones;

	public String getZone() {
		return zone;
	}

	public String getName() {
		return name;
	}

	public PlantDouble(String name, HardinessZoneDouble... hardinessZones) {
		this.name = name;
		this.hardinessZones = new ArrayList<>(Arrays.asList(hardinessZones));
	}

	public List<HardinessZoneDouble> getZones() {
		return hardinessZones;
	}

}

package org.wecancodeit.columbus.plantplanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PlantDouble {

	private String zone;

	public String getZone() {
		return zone;
	}

	public String getName() {
		return name;
	}

	private String name;
	private List<HardinessZoneDouble> hardinessZones;

	public PlantDouble(String zone, String name) {
		this.zone = zone;
		this.name = name;

	}

	public PlantDouble(String string, HardinessZoneDouble... hardinessZones) {
		this.hardinessZones = new ArrayList<>(Arrays.asList(hardinessZones));
	}

	public List<HardinessZoneDouble> getZones() {
		return hardinessZones;
	}

}

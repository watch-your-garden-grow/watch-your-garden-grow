package org.wecancodeit.columbus.plantplanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Report {

	private final String zipcode;
	private final String zone;
	private final LocalDate lastFrost;
	private final Collection<ReportItem> reportItems = new ArrayList<>();

	public Report(String zipcode, String zone) {
		this.zipcode = zipcode;
		this.zone = zone;
		lastFrost = LocalDate.of(LocalDate.now().getYear(), 4, 20); // TODO Should get from zone
	}

	public Report(ZipCodeLocality zipCodeLocality) {
		this(zipCodeLocality.getZipcode(), zipCodeLocality.getZone());
	}

	public LocalDate getLastFrost() {
		return lastFrost;
	}

	public void createReportItemFromPlant(Plant plant) {
		reportItems.add(new ReportItem(plant, lastFrost));
	}

	public void createReportItemsFromPlant(Plant... plants) {
		for (Plant plant : plants) {
			createReportItemFromPlant(plant);
		}
	}
	
	public void createReportItemsFromPlant(Collection<Plant> plants) {
		plants.forEach(plant -> createReportItemFromPlant(plant));
	}

	public Collection<ReportItem> getReportItems() {
		return reportItems;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getZone() {
		return zone;
	}

}
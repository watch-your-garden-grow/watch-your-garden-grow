package org.wecancodeit.columbus.plantplanner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Report {

	private final String zipcode;
	private final String zone;
	private final LocalDate lastFrost;
	private final Collection<ReportItem> reportItems = new ArrayList<>();
	private final DayOfWeek defaultWorkDay = DayOfWeek.SATURDAY;
	private DayOfWeek requestedWorkDay = defaultWorkDay;
	
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
		reportItems.add(new ReportItem(plant, lastFrost, requestedWorkDay));
	}

	public void createReportItemsFromPlant(Plant... plants) {
		for (Plant plant : plants) {
			createReportItemFromPlant(plant);
		}
	}

	public void createReportItemsFromPlant(Collection<Plant> plants) {
		plants.forEach(plant -> createReportItemFromPlant(plant));
	}

	public void createReportItemsFromPlantPlan(PlantPlan plantPlan) {
		plantPlan.getPlantPlanItems().forEach(planItem -> createReportItemsFromPlant(planItem.getPlant()));
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

	public DayOfWeek getWorkDay() {
		return requestedWorkDay;
	}

	public void setWorkDay(DayOfWeek workDay) {
		this.requestedWorkDay = workDay;
	}

}

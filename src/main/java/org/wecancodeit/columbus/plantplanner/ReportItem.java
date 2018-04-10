package org.wecancodeit.columbus.plantplanner;

import java.time.LocalDate;

public class ReportItem {

	private Plant plant;
	private LocalDate frostDate = LocalDate.of(LocalDate.now().getYear(), 4, 20);

	public ReportItem(Plant plant) {
		this.plant = plant;

	}

	public Plant getPlant() {

		return plant;
	}

	public LocalDate reportSowDate() {
		int daysAfterFrostToPlant = plant.daysSinceLastFrost();

		return frostDate.plusDays(daysAfterFrostToPlant);
	}
}

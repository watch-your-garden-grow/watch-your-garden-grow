package org.wecancodeit.columbus.plantplanner;

import java.time.LocalDate;

public class ReportItem {

	private final Plant plant;
	private LocalDate frostDate = LocalDate.of(LocalDate.now().getYear(), 4, 20);
	private LocalDate sowDate;

	public ReportItem(Plant plant, LocalDate lastFrost) {
		this.plant = plant;
		this.frostDate = lastFrost;
		this.sowDate = calculateSowDate();
	}
	public ReportItem(Plant plant) {
		this.plant = plant;
		this.sowDate = calculateSowDate();
	}

	public Plant getPlant() {
		return plant;
	}

	private LocalDate calculateSowDate() {
		int daysAfterFrostToPlant = plant.daysSinceLastFrost();
		return frostDate.plusDays(daysAfterFrostToPlant);
	}

	public LocalDate getSowDate() {
		return sowDate;
	}
}

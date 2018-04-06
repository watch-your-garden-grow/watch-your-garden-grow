package org.wecancodeit.columbus.plantplanner;

import java.time.LocalDate;

public class ReportItem {

	private Plant plant;

	public ReportItem(Plant plant) {
		this.plant = plant;

	}

	public Plant getPlant() {

		return plant;
	}

	public LocalDate reportSowDate() {
		return LocalDate.of(LocalDate.now().getYear(), 4, 20);
	}
}

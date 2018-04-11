package org.wecancodeit.columbus.plantplanner;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ReportItem {

	private final Plant plant;
	private LocalDate lastFrost = LocalDate.of(LocalDate.now().getYear(), 4, 20);
	private LocalDate earliestSowDate;
	private final DayOfWeek defaultWorkDay = DayOfWeek.SATURDAY;

	public ReportItem(Plant plant, LocalDate lastFrost) {
		this.plant = plant;
		this.lastFrost = lastFrost;
		this.earliestSowDate = calculateEarliestSowDateSowDate();
	}

	public ReportItem(Plant plant) {
		this.plant = plant;
		this.earliestSowDate = calculateEarliestSowDateSowDate();
	}

	public Plant getPlant() {
		return plant;
	}

	private LocalDate calculateEarliestSowDateSowDate() {
		int daysAfterFrostToPlant = plant.daysSinceLastFrost();
		return lastFrost.plusDays(daysAfterFrostToPlant);
	}

	public LocalDate calculateUserSowDate() {
		return calculateUserSowDate(this.defaultWorkDay);
	}

	public LocalDate calculateUserSowDate(DayOfWeek requestedWorkDay) {
		LocalDate userSowDate = earliestSowDate;

		DayOfWeek sowDay = earliestSowDate.getDayOfWeek();
		int daysApart = requestedWorkDay.getValue() - sowDay.getValue();

		if (daysApart < 0) {
			userSowDate = earliestSowDate.plusDays(daysApart + 7);
		} else if (daysApart > 0) {
			userSowDate = earliestSowDate.plusDays(daysApart);
		}

		return userSowDate;
	}

	public LocalDate getEarliestSowDate() {
		return earliestSowDate;
	}
}

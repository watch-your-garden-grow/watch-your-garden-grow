package org.wecancodeit.columbus.plantplanner;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ReportItem {

	private final Plant plant;
	private LocalDate lastFrost = LocalDate.of(LocalDate.now().getYear(), 4, 20);
	private LocalDate earliestSowDate;
	private LocalDate requestedSowDate;

	public ReportItem(Plant plant, LocalDate lastFrost, DayOfWeek workDay) {
		this.plant = plant;
		this.lastFrost = lastFrost;
		this.earliestSowDate = calculateEarliestSowDateSowDate();
		this.requestedSowDate = calculateUserSowDate(workDay);
	}

	public ReportItem(Plant plant, DayOfWeek workDay) {
		this.plant = plant;
		this.earliestSowDate = calculateEarliestSowDateSowDate();
		this.requestedSowDate = calculateUserSowDate(workDay);
	}

	public Plant getPlant() {
		return plant;
	}

	private LocalDate calculateEarliestSowDateSowDate() {
		int daysAfterFrostToPlant = plant.daysSinceLastFrost();
		return lastFrost.plusDays(daysAfterFrostToPlant);
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

	public LocalDate getRequestedSowDate() {
		return requestedSowDate;
	}

}

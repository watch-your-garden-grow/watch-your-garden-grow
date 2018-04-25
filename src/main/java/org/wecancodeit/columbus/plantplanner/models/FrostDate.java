package org.wecancodeit.columbus.plantplanner.models;

import java.time.LocalDate;

public class FrostDate {
	private LocalDate lastFrostDate;

	public FrostDate() {
		lastFrostDate = LocalDate.of(LocalDate.now().getYear(), 4, 20);
	}

	public LocalDate reportLastFrostDate() {

		return lastFrostDate;
	}

}
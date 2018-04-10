package org.wecancodeit.columbus.plantplanner;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReportItem {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Plant plant;
	@ManyToOne
	private PlanCart planCart;

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

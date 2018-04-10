package org.wecancodeit.columbus.plantplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PlantPlanItem {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Plant plant;

	@JsonIgnore
	@ManyToOne
	PlantPlan plantPlan;

	PlantPlanItem() {
	}

	public PlantPlanItem(Plant plant) {
		this.plant = plant;
	}

	public Long getId() {
		return id;
	}

	public Plant getPlant() {
		return plant;
	}

	public PlantPlan getPlantPlan() {
		return plantPlan;
	}
}

package org.wecancodeit.columbus.plantplanner.models;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlantPlan {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "plantPlan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<PlantPlanItem> plantPlanItems = new LinkedHashSet<>();

	public PlantPlan() {
	}

	public PlantPlan addPlantPlanItem(PlantPlanItem plantPlanItem) {
		if (!plantPlanItems.contains(plantPlanItem)) {
			plantPlanItems.add(plantPlanItem);
			plantPlanItem.plantPlan = this;
		}
		return this;
	}

	public PlantPlan removePlantPlanItem(PlantPlanItem plantPlanItem) {
		plantPlanItems.remove(plantPlanItem);
		plantPlanItem.plantPlan = null;
		return this;
	}

	public Long getId() {
		return id;
	}

	public Set<PlantPlanItem> getPlantPlanItems() {
		return plantPlanItems;
	}
}

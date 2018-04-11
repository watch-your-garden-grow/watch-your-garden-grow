package org.wecancodeit.columbus.plantplanner;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PlantPlanItemRepository extends CrudRepository<PlantPlanItem, Long> {

	Optional<PlantPlanItem> findByPlantPlanIdAndPlantId(Long plantPlanId, Long planttId);
}

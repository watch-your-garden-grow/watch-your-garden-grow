package org.wecancodeit.columbus.plantplanner.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.columbus.plantplanner.models.PlantPlanItem;

public interface PlantPlanItemRepository extends CrudRepository<PlantPlanItem, Long> {

	Optional<PlantPlanItem> findByPlantPlanIdAndPlantId(Long plantPlanId, Long planttId);
}

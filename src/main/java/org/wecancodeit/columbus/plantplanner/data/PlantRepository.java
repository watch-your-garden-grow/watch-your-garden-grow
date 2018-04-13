package org.wecancodeit.columbus.plantplanner.data;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.columbus.plantplanner.models.Plant;

public interface PlantRepository extends CrudRepository<Plant, Long> {

}

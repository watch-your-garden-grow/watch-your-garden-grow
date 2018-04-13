package org.wecancodeit.columbus.plantplanner.data;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.columbus.plantplanner.models.Zone;

public interface ZoneRepository extends CrudRepository<Zone, Long> {

	Zone findOneByZone(String zone);

}

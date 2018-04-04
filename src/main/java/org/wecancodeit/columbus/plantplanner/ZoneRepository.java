package org.wecancodeit.columbus.plantplanner;

import org.springframework.data.repository.CrudRepository;

public interface ZoneRepository extends CrudRepository<Zone, Long> {

	Zone findOneByZone(String zone);

}

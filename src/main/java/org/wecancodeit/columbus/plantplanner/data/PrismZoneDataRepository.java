package org.wecancodeit.columbus.plantplanner.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.wecancodeit.columbus.plantplanner.models.PrismZoneData;

public interface PrismZoneDataRepository extends JpaRepository<PrismZoneData, Long> {

	PrismZoneData findByZoneAndTrange(String zone, String trange);
}

package org.wecancodeit.columbus.plantplanner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrismZoneDataRepository extends JpaRepository<PrismZoneData, Long> {

	PrismZoneData findByZoneAndTrange(String zone, String trange);
}

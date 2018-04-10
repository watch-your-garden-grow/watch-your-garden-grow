package org.wecancodeit.columbus.plantplanner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ZipCodeLocalityRepository extends JpaRepository<ZipCodeLocality, Long> {

	ZipCodeLocality findOneByZipcode(String zipcode);

	@Query("SELECT p.zoneData.zone FROM ZipCodeLocality p where p.zipcode = :zipcode")
	String findZoneByZipCode(@Param("zipcode") String zipcode);

	ZipCodeLocality findByZipcode(String zipcode);

}

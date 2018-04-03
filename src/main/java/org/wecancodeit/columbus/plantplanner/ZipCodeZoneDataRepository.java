package org.wecancodeit.columbus.plantplanner;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ZipCodeZoneDataRepository extends CrudRepository<ZipCodeZoneData, Long> {

	Collection<ZipCodeZoneData> findByZipcode(String zipcode);

	@Query("SELECT zipCodeZoneData.zone FROM ZipCodeZoneData zipCodeZoneData where zipCodeZoneData.zipcode = :zipcode")
	String findZoneByZipCode(@Param("zipcode") String zipcode);

}

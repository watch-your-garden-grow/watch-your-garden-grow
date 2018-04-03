package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataMappingTests {

	@Resource
	private ZipCodeLocalityRepository zipCodeLocalityRepo;

	@Resource
	private PrismZoneDataRepository prismZoneDataRepo;

	ZipCodeLocality localityUnderTest;
	PrismZoneData prismDataUnderTest;
	
	@Before
	public void runOnce() {
	localityUnderTest = new ZipCodeLocality();
	localityUnderTest.setZipcode("TESTTEST");
	localityUnderTest= zipCodeLocalityRepo.save(localityUnderTest);
	
	prismDataUnderTest = new PrismZoneData("", "42");
	localityUnderTest = zipCodeLocalityRepo.save(localityUnderTest.addZoneData(prismDataUnderTest));
	prismDataUnderTest = prismZoneDataRepo.save(prismDataUnderTest);

	}

	@Test
	public void createZipCodeZoneData() {
		assertThat(prismDataUnderTest.getZone(), is("42"));
	}

	@Test
	public void checkThatfindByZipcodeReturnsCorrectData() {
		ZipCodeLocality testZone = zipCodeLocalityRepo.findByZipcode("TESTTEST");
		assertThat(testZone.getZone(), is("42"));
	}

	@Test
	public void checkThatfindZoneByZipCodeReturnsZoneData() {
		assertThat(zipCodeLocalityRepo.findZoneByZipCode("TESTTEST"), is("42"));
	}
	

}

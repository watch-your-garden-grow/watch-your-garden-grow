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

	ZipCodeLocality localityOneUnderTest, localityTwoUnderTest;
	PrismZoneData prismDataOneUnderTest, prismDataTwoUnderTest, prismDataThreeUnderTest;

	@Before
	public void runOnce() {
		localityOneUnderTest = new ZipCodeLocality();
		localityOneUnderTest.setZipcode("TESTTEST");
		localityOneUnderTest = zipCodeLocalityRepo.save(localityOneUnderTest);

		localityTwoUnderTest = new ZipCodeLocality();
		localityTwoUnderTest.setZipcode("TESTTWO");
		localityTwoUnderTest = zipCodeLocalityRepo.save(localityTwoUnderTest);

		prismDataOneUnderTest = new PrismZoneData("", "42", "TRANGEONE", "TITLEONE");
		prismDataTwoUnderTest = new PrismZoneData("", "43", "TRANGETWO", "TITLETWO");
		prismDataThreeUnderTest = new PrismZoneData("X", "43", "TRANGETWO", "TITLETWO");

		localityOneUnderTest = zipCodeLocalityRepo.save(localityOneUnderTest.addZoneData(prismDataOneUnderTest));

		localityTwoUnderTest = zipCodeLocalityRepo.save(localityTwoUnderTest.addZoneData(prismDataTwoUnderTest));

		localityTwoUnderTest = zipCodeLocalityRepo.save(localityTwoUnderTest.addZoneData(prismDataThreeUnderTest));
<<<<<<< HEAD
=======

>>>>>>> 358909e0cb61cf7a5c180e082395218bf9c0c6c7

	}

	@Test
	public void createZipCodeZoneData() {
		assertThat(prismDataOneUnderTest.getZone(), is("42"));
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

	@Test
	public void checkThatOnlyTwoZonesAreInDataBase() {

		assertThat(prismZoneDataRepo.findAll().size(), is(2));
	}
<<<<<<< HEAD
=======

>>>>>>> 358909e0cb61cf7a5c180e082395218bf9c0c6c7

}

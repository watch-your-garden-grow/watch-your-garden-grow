package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZipCodeDataTests {

	@Resource
	private ZipCodeZoneDataRepository zipCodeRepo;

	ZipCodeZoneData underTest;
	
	@Before
	public void setup() {
	underTest = new ZipCodeZoneData("43202", "6a");
	}

	@Test
	public void createZipCodeZoneData() {
		assertThat(underTest.getZone(), is("6a"));
	}

	@Test
	public void checkThatfindByZipcodeReturnsCorrectData() {
		underTest = zipCodeRepo.save(underTest);
		Collection<ZipCodeZoneData> testZone = zipCodeRepo.findByZipcode("43202");

		assertThat(testZone.iterator().next().getZone(), is("6a"));
	}

	@Test
	public void checkThatfindZoneByZipCodeReturnsZoneData() {
		underTest = zipCodeRepo.save(underTest);

		assertThat(zipCodeRepo.findZoneByZipCode("43202"), is("6a"));
	}

}

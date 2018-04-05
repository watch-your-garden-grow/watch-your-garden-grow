package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FrostDateTest {
	ZipCodeLocality testZipCode = new ZipCodeLocality("99553", "", "", "", "", "", 54.143, -165.7854);
	FrostDate underTest = new FrostDate(testZipCode);
	ZipCodeLocality testZipCode2 = new ZipCodeLocality("99506", "", "", "", "", "", 59.8666, -158.5996);

	@Test
	public void shouldSaveZipCodeDataFromConstructor() {
		ZipCodeLocality result = underTest.getZipCode();
		assertThat(result.getZipcode(), is("99553"));
	}

	@Test
	public void shouldFindClosetStationToZIpCodeFromFarmSenseApi() {
		String result = underTest.findClosestStation();
		assertThat(result, is("502102"));
	}

	@Test
	public void shouldFindAnotherColsestStationToZipCodeFromFarmSenseAPI() {
		String result = null;
		assertThat(result, is("504766"));
	}

}

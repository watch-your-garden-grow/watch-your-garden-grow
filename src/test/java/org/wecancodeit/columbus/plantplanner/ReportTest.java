package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class ReportTest {

	String testZipcode = "43202";
	String testZone = "6a";
	PrismZoneData prismZoneDataUnderTest;
	ZipCodeLocality zipCodeLocalityUnderTest;
	Report reportUnderTest;
	Plant plantOneUnderTest;
	Plant plantTwoUnderTest;

	@Before
	public void setUp() throws Exception {
		prismZoneDataUnderTest = new PrismZoneData(testZipcode, testZone);
		zipCodeLocalityUnderTest = new ZipCodeLocality(testZipcode, "", "", "", "", "", 0, 0);
		zipCodeLocalityUnderTest.addZoneData(prismZoneDataUnderTest);
		reportUnderTest = new Report(zipCodeLocalityUnderTest);
		plantOneUnderTest = new Plant("PlantOne", "", "", 14);
		plantTwoUnderTest = new Plant("PlantTwo", "", "", 20);
	}

	@Test
	public void reportClassAcceptsZipCodeAndZone() throws Exception {
		Report underTest = new Report(testZipcode, testZone);
		assertThat(underTest, is(notNullValue()));
	}

	@Test
	public void reportZipCodeAcceptsLocality() throws Exception {
		PrismZoneData zd = new PrismZoneData(testZipcode, testZone);
		ZipCodeLocality zcl = new ZipCodeLocality(testZipcode, "", "", "", "", "", 0, 0);
		zcl.addZoneData(zd);
		Report underTest = new Report(zcl);
		assertThat(underTest, is(notNullValue()));
	}

	@Test
	public void getLastFrostReturnsDummyFrostDate420() throws Exception {
		assertThat(reportUnderTest.getLastFrost(), is(LocalDate.of(LocalDate.now().getYear(), 4, 20)));
	}

	@Test
	public void createReportItemFromPlantShouldAddReportItem() throws Exception {
		reportUnderTest.createReportItemFromPlant(plantOneUnderTest);
		Plant reportedPlant = reportUnderTest.getReportItems().iterator().next().getPlant();
		assertThat(reportedPlant, is(plantOneUnderTest));
	}

	@Test
	public void createReportItemsFromPlantPlantArray() throws Exception {
		reportUnderTest.createReportItemsFromPlant(plantOneUnderTest, plantTwoUnderTest);
		Plant reportedPlant = reportUnderTest.getReportItems().iterator().next().getPlant();
		assertThat(reportedPlant, is(plantOneUnderTest));
	}
	
	@Test
	public void createReportItemsFromPlantPlantCollection() throws Exception {
		Collection<Plant>  plants = new ArrayList<>();
		plants.add(plantOneUnderTest);
		plants.add(plantTwoUnderTest);
		reportUnderTest.createReportItemsFromPlant(plants);
		
		Collection<ReportItem> reportItems = reportUnderTest.getReportItems();
		assertThat(reportItems.size(), is(2));
		

		Plant reportedPlant = reportItems.iterator().next().getPlant();
		assertThat(reportedPlant, is(plantOneUnderTest));
	}

	

	@Test
	public void getZipcodeShouldReturnZipcode() throws Exception {
		assertThat(reportUnderTest.getZipcode(), is(testZipcode));
	}

	@Test
	public void getZipCodeShouldReturnZone() throws Exception {
		assertThat(reportUnderTest.getZone(), is(testZone));
	}

}

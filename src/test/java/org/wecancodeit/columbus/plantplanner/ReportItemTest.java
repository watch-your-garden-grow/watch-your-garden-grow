package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class ReportItemTest {
	Plant dummyPlant = new Plant("Banana", "", "", 0);
	ReportItem underTest = new ReportItem(dummyPlant);

	@Test
	public void shouldHaveAPlant() {
		String result = underTest.getPlant().getName();
		assertThat(result, is("Banana"));

	}

	@Test
	public void shouldHaveASowDate() {
		LocalDate sowDate = underTest.reportSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 4, 20)));
	}

	@Test
	public void tomatoShouldHave504asASowDate() {
		Plant dummyTomato = new Plant("Tomato", "", "", 14);
		ReportItem test2 = new ReportItem(dummyTomato);
		LocalDate sowDate = test2.reportSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 4)));
	}

	@Test
	public void cantelopeShouldHave510AsASowDate() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 20);
		ReportItem test2 = new ReportItem(dummyCantelope);
		LocalDate sowDate = test2.reportSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 10)));
	}
}

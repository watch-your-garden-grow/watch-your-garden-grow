package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;

public class ReportItemTest {
	Plant dummyPlant = new Plant("Banana", "", "");
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

}

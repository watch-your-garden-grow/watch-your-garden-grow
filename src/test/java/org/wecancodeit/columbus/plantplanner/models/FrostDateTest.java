package org.wecancodeit.columbus.plantplanner.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Test;
import org.wecancodeit.columbus.plantplanner.models.FrostDate;

public class FrostDateTest {

	@Test
	public void shouldReturn420AsALastFrostDate() {
		FrostDate underTest = new FrostDate();
		LocalDate result = underTest.reportLastFrostDate();
		assertThat(result, is(LocalDate.of(LocalDate.now().getYear(), 4, 20)));
	}
}
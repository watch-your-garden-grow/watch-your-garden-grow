package org.wecancodeit.columbus.plantplanner.models;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;

import org.junit.Test;
import org.wecancodeit.columbus.plantplanner.models.Plant;
import org.wecancodeit.columbus.plantplanner.models.ReportItem;

public class ReportItemTest {
	Plant dummyPlant = new Plant("Banana", "", "", 0);
	ReportItem underTest = new ReportItem(dummyPlant, DayOfWeek.SATURDAY);

	
	@Test
	public void shouldHaveAPlant() {
		String result = underTest.getPlant().getName();
		assertThat(result, is("Banana"));

	}

	@Test
	public void shouldHaveASowDate() {
		LocalDate sowDate = underTest.getEarliestSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 4, 20)));
	}

	@Test
	public void tomatoShouldHave504asASowDate() {
		Plant dummyTomato = new Plant("Tomato", "", "", 14);
		ReportItem test2 = new ReportItem(dummyTomato, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.getEarliestSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 4)));
	}

	@Test
	public void cantelopeShouldHave510AsASowDate() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 20);
		ReportItem test2 = new ReportItem(dummyCantelope, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.getEarliestSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 10)));
	}
	
	// 420 + 20 = 510 (Thursday)
	@Test
	public void cantelopeShouldHave512AsUserSowDateForSaturdday() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 20);
		ReportItem test2 = new ReportItem(dummyCantelope, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.getRequestedSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 12)));
	}
	
	@Test
	public void cantelopeShouldHave519AsSowDateGivenNegativeDifference() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 23);
		ReportItem test2 = new ReportItem(dummyCantelope, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.getRequestedSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 19)));
	}
	
	@Test
	public void cantelopeShouldHave512AsSowDateGivenZeroDifference() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 22);
		ReportItem test2 = new ReportItem(dummyCantelope, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.getRequestedSowDate();
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 12)));
	}
	
	@Test
	public void cantelopeShouldHave532AsUserSowDateForSunday() {
		Plant dummyCantelope = new Plant("Tomato", "", "", 20);
		ReportItem test2 = new ReportItem(dummyCantelope, DayOfWeek.SATURDAY);
		LocalDate sowDate = test2.calculateUserSowDate(DayOfWeek.SUNDAY);
		assertThat(sowDate, is(LocalDate.of(LocalDate.now().getYear(), 5, 13)));
	}
	
	
}

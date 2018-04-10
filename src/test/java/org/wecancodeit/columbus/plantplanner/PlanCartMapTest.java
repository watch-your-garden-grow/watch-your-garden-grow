package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class PlanCartMapTest {
	@Resource
	PlanCartRepository planCartRepo;

	@Test
	public void shouldHaveAnId() {
		PlanCart underTest1 = new PlanCart();
		underTest1 = planCartRepo.save(underTest1);
		PlanCart underTest2 = new PlanCart();
		underTest2 = planCartRepo.save(underTest2);
		Long id1 = underTest1.getId();
		Long id2 = underTest2.getId();
		assertThat(id1, is(notNullValue()));
		assertThat(id2, is(notNullValue()));
	}

	@Test
	public void shouldAddAReportItem() {
		PlanCart underTest1 = new PlanCart();
		underTest1 = planCartRepo.save(underTest1);
		Plant dummyPlant1 = new Plant("Banana", "", "", 0);
		ReportItem testReportItem1 = new ReportItem(dummyPlant1);
		underTest1.addReportItem(testReportItem1);
		Collection<ReportItem> result = underTest1.getReportItems();
		assertThat(result, hasItems(testReportItem1));
	}

	@Test
	public void shouldAddTwoItemsAndRemoveOne() {
		PlanCart underTest1 = new PlanCart();
		underTest1 = planCartRepo.save(underTest1);
		Plant dummyPlant1 = new Plant("Banana", "", "", 0);
		ReportItem testReportItem1 = new ReportItem(dummyPlant1);
		Plant dummyPlant2 = new Plant("Tomato", "", "", 14);
		ReportItem testReportItem2 = new ReportItem(dummyPlant2);
		underTest1.addReportItem(testReportItem1);
		underTest1.addReportItem(testReportItem2);
		assertThat(underTest1.getReportItems().size(), is(2));
		underTest1.removeReportItem(testReportItem2);
		Collection<ReportItem> result = underTest1.getReportItems();
		assertThat(underTest1.getReportItems().size(), is(1));
		assertThat(result, hasItems(testReportItem1));
	}

}

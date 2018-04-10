package org.wecancodeit.columbus.plantplanner;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PlanCart {
	@GeneratedValue
	@Id
	private Long id;
	@OneToMany
	private Collection<ReportItem> reportItems;

	public Long getId() {

		return id;
	}

	public Collection<ReportItem> getReportItems() {

		return reportItems;
	}

	public PlanCart(ReportItem... reportItems) {
		this.reportItems = new HashSet<>(asList(reportItems));
	}

	public void addReportItem(ReportItem testReportItem) {
		reportItems.add(testReportItem);

	}

	public void removeReportItem(ReportItem testReportItem) {
		this.reportItems.remove(testReportItem);

	}
}

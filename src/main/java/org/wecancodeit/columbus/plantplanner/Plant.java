package org.wecancodeit.columbus.plantplanner;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Plant {

	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	private Collection<ReportItem> reportItems;
	private String name;
	private String image;
	private String description;

	private int daysSinceLastFrost;

	@JsonIgnore
	@ManyToMany
	private Set<Zone> zones;

	public Set<Zone> getZones() {
		return zones;
	}

	public Plant() {
	}

	public Plant(String name, String description, String image, int daysSinceLastFrost, Zone... zones) {
		this.name = name;
		this.description = description;
		this.image = image;
		this.daysSinceLastFrost = daysSinceLastFrost;
		this.zones = new HashSet<>(asList(zones));
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return image;
	}

	public int daysSinceLastFrost() {
		return daysSinceLastFrost;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Plant) obj).id;
	}
}

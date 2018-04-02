package org.wecancodeit.columbus.plantplanner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plant {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	public Plant() {

	}

	public Plant(String name) {
		this.name = name;

	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}

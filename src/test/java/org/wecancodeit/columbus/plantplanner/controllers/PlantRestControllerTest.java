package org.wecancodeit.columbus.plantplanner.controllers;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.wecancodeit.columbus.plantplanner.controllers.PlantRestController;
import org.wecancodeit.columbus.plantplanner.controllers.PlantRestController.SomethingNotFoundException;
import org.wecancodeit.columbus.plantplanner.data.PlantRepository;
import org.wecancodeit.columbus.plantplanner.data.PrismZoneDataRepository;
import org.wecancodeit.columbus.plantplanner.data.ZipCodeLocalityRepository;
import org.wecancodeit.columbus.plantplanner.data.ZoneRepository;
import org.wecancodeit.columbus.plantplanner.models.Plant;
import org.wecancodeit.columbus.plantplanner.models.PrismZoneData;
import org.wecancodeit.columbus.plantplanner.models.ZipCodeLocality;
import org.wecancodeit.columbus.plantplanner.models.Zone;



public class PlantRestControllerTest {

	@InjectMocks
	private PlantRestController underTest;

	@Mock
	private Plant plant;

	@Mock
	private PlantRepository plantRepo;

	@Mock
	private ZoneRepository zoneRepo;

	@Mock
	private Collection<Plant> plants;

	@Mock
	private Zone zone;

	@Mock
	private ZipCodeLocality zipcode;

	@Mock
	private PrismZoneData hardinessZone;

	@Mock
	private PrismZoneDataRepository hardinessZoneRepo;

	@Mock
	private ZipCodeLocalityRepository zipCodeRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldRetrievePlants() {
		when(plantRepo.findAll()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlants();
		assertThat(result, contains(any(Plant.class)));
	}

	@Test
	public void shouldGetPlantsFromDatabase() {
		when(plantRepo.findAll()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlants();
		assertThat(result, contains(plant));
	}

	@Test
	public void shouldReturnIndividualPlantFromDatabase() {
		when(plantRepo.findOne(3L)).thenReturn(plant);
		Plant result = underTest.findPlant(3L);
		assertThat(result, is(plant));
	}

	@Test(expected = SomethingNotFoundException.class)
	public void shouldReturnNotFoundExceptionForBadProductId() {
		long invalidProductId = 42L;
		underTest.findPlant(invalidProductId);
	}

	@Test
	public void shouldReturnAListOfZones() {
		when(zoneRepo.findAll()).thenReturn(Collections.singleton(zone));
		Iterable<Zone> result = underTest.findZones();
		assertThat(result, contains(any(Zone.class)));

	}

	@Test
	public void shouldReturnIndividualZoneFromDatabase() {
		when(zoneRepo.findOne(3L)).thenReturn(zone);
		Zone result = underTest.findZone(3L);
		assertThat(result, is(zone));
	}

	@Test
	public void shouldReturnAListOfPlantsForGivenZone() {
		Long zoneId = 3L;
		when(zoneRepo.findOne(zoneId)).thenReturn(zone);
		when(zone.getPlants()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlantsByZoneId(zoneId);
		assertThat(result, contains(plant));
	}

	@Test
	public void shouldReturnAPlantHardinessZoneForAGivenZipcode() {
		when(zipCodeRepo.findZoneByZipCode("43221")).thenReturn("42");
		String result = underTest.findPhzByZipcode("43221");
		assertThat(result, is("42"));
	}

	@Test
	public void shouldReturnAListOfPlantsForAGivenPhzName() {
		when(zoneRepo.findOneByZone("6a")).thenReturn(zone);
		when(zone.getPlants()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlantsByZone("6a");
		assertThat(result, contains(plant));
	}

	@Test
	public void shouldReturnAListOfPlantsForAGivenZipcode() {
		when(zipCodeRepo.findZoneByZipCode("43229")).thenReturn("6a");
		when(zoneRepo.findOneByZone("6a")).thenReturn(zone);
		when(zone.getPlants()).thenReturn(Collections.singleton(plant));
		Iterable<Plant> result = underTest.findPlantsByZipcode("43229");
		assertThat(result, contains(plant));
	}
}
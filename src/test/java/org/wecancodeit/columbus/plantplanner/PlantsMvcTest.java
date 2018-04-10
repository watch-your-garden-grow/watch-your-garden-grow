package org.wecancodeit.columbus.plantplanner;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PlantRestController.class)
public class PlantsMvcTest {

	@Resource
	MockMvc mvc;

	@MockBean
	private PlantRepository plantRepo;

	@MockBean
	private ZoneRepository zoneRepo;

	@MockBean
	private ZipCodeLocalityRepository zipcodeRepo;

	@Test
	public void shouldRetrievePlants() throws Exception {
		mvc.perform(get("/plants")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveIndividualPlant() throws Exception {
		when(plantRepo.findOne(3L)).thenReturn(new Plant("Tomato", "", "", 0));
		mvc.perform(get("/plants/3")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindPlantId() throws Exception {
		mvc.perform(get("/plants/42")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldRetrieveZones() throws Exception {
		mvc.perform(get("/zones")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrieveIndividualZone() throws Exception {
		when(zoneRepo.findOne(3L)).thenReturn(new Zone("3"));
		mvc.perform(get("/zones/3")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindZoneId() throws Exception {
		mvc.perform(get("/zones/42")).andExpect(status().isNotFound());
	}

	@Test
	public void shouldRetrievePlantsFromAZone() throws Exception {
		when(zoneRepo.findOne(3L)).thenReturn(new Zone("3"));
		mvc.perform(get("/zone/3")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrievePhzFromZipcode() throws Exception {
		when(zipcodeRepo.findZoneByZipCode("43229")).thenReturn("42");
		mvc.perform(get("/zipcode/43229")).andExpect(status().isOk());
	}

	@Test
	public void shouldRetrievePlantsFromZipcode() throws Exception {
		when(zipcodeRepo.findZoneByZipCode("43229")).thenReturn("42");
		when(zoneRepo.findOneByZone("42")).thenReturn(new Zone("6a"));
		mvc.perform(get("/plants/zipcode/43229")).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFindInvalidZipcode() throws Exception {
		mvc.perform(get("/plants/zipcode/3323111")).andExpect(status().isNotFound());
	}

<<<<<<< HEAD

	
=======
>>>>>>> origin/BuddhaBellyController
}
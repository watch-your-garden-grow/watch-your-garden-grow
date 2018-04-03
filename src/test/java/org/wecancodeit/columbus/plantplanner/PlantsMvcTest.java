package org.wecancodeit.columbus.plantplanner;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(PlantController.class)
public class PlantsMvcTest {

	@Resource
	MockMvc mvc;
	
	@MockBean
	private PlantRepository plantRepo;
	
	@MockBean
	private ZoneRepository zoneRepo;
	
	@Test
	public void shouldRetrievePlants() throws Exception {
		mvc.perform(get("/plants")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldRetrieveIndividualPlant() throws Exception {
		when(plantRepo.findOne(3L)).thenReturn(new Plant("Tomato"));
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
}

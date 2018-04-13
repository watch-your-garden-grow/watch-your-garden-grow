package org.wecancodeit.columbus.plantplanner;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
@WebMvcTest(PlantTemplateController.class)
public class PlantMvcControllerTest {

	@Resource
	MockMvc mvc;

	@MockBean
	private PlantRepository plantRepo;

	@Test
	public void shouldRetrieveIndividualPlantTemplate() throws Exception {
		Plant plantTest = new Plant("Tomato", "", "", 0);
		when(plantRepo.findOne(3L)).thenReturn(plantTest);
		mvc.perform(get("/plant?id=3")).andExpect(status().isOk()).andExpect(view().name("plant"))
				.andExpect(model().attribute("plant", is(plantTest)));
	}

	@Test
	public void shouldNotRetrieveIndividualPlantTemplate() throws Exception {
		when(plantRepo.findOne(13L)).thenReturn(null);
		mvc.perform(get("/plant?id=13")).andExpect(status().isOk()).andExpect(view().name("notFound"));
	}

}

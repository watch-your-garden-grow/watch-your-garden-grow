package org.wecancodeit.columbus.plantplanner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

public class PlantTemplateControllerTest {
	@InjectMocks
	private PlantTemplateController underTest;
	@Mock
	private PlantRepository plantRepo;
	@Mock
	private Plant plant;
	@Mock
	private Model model;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldAddIndividualPlantToModel() {
		Long arbritaryPlantId = 42L;
		when(plantRepo.findOne(arbritaryPlantId)).thenReturn(plant);
		underTest.showPlant(arbritaryPlantId, model);
		verify(model).addAttribute("plant", plant);
	}

}
// Long arbritaryCategoryId = 42L;
// when(categoryRepo.findOne(arbritaryCategoryId)).thenReturn(category1);
// underTest.showCategory(arbritaryCategoryId, model);
// verify(model).addAttribute("selectedCategory", category1);

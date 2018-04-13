package org.wecancodeit.columbus.plantplanner.controllers;

import java.util.Comparator;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wecancodeit.columbus.plantplanner.data.PlantPlanItemRepository;
import org.wecancodeit.columbus.plantplanner.data.PlantPlanRepository;
import org.wecancodeit.columbus.plantplanner.data.PlantRepository;
import org.wecancodeit.columbus.plantplanner.data.ZipCodeLocalityRepository;
import org.wecancodeit.columbus.plantplanner.models.Plant;
import org.wecancodeit.columbus.plantplanner.models.PlantPlan;
import org.wecancodeit.columbus.plantplanner.models.PlantPlanItem;
import org.wecancodeit.columbus.plantplanner.models.Report;
import org.wecancodeit.columbus.plantplanner.models.ReportItem;

@Controller
public class PlantPlanController {

	private Logger log = LoggerFactory.getLogger(PlantPlanController.class);

	@Resource
	private PlantRepository plantRepository;

	@Resource
	private PlantPlanRepository plantPlanRepository;

	@Resource
	private PlantPlanItemRepository plantPlanItemRepository;

	@Resource
	private ZipCodeLocalityRepository zipCodeRepo;

	@ResponseBody
	@GetMapping(value = "/api/plantplan")
	public HttpEntity<PlantPlan> getNewPlantPlan() {
		PlantPlan newPlantPlan = plantPlanRepository.save(new PlantPlan());
		return new ResponseEntity<>(newPlantPlan, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(value = "/api/plantplan/{plantPlanId}")
	public HttpEntity<PlantPlan> getPlanContents(@PathVariable("plantPlanId") Long plantPlanId) {
		PlantPlan plantplan = plantPlanRepository.findOne(plantPlanId);
		return new ResponseEntity<>(plantplan, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(value = "/api/plantplan/{plantPlanId}/plant/{plantId}")
	public HttpEntity<String> addPlantToPlan(@PathVariable(value = "plantPlanId") Long plantPlanId,
			@PathVariable(value = "plantId") Long plantId) {
		Plant plant = plantRepository.findOne(plantId);

		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);

		PlantPlanItem plantPlanItem = plantPlanItemRepository.findByPlantPlanIdAndPlantId(plantPlanId, plantId)
				.orElseGet(() -> plantPlanItemRepository.save(new PlantPlanItem(plant)));

		plantPlan = plantPlanRepository.save(plantPlan.addPlantPlanItem(plantPlanItem));

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@ResponseBody
	@DeleteMapping(value = "/api/plantplan/{plantPlanId}/plant/{plantId}")
	public HttpEntity<String> deletePlantFromPlan(@PathVariable(value = "plantPlanId") Long plantPlanId,
			@PathVariable(value = "plantId") Long plantId) {
		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);
		PlantPlanItem plantPlanItem = plantPlanItemRepository.findByPlantPlanIdAndPlantId(plantPlanId,plantId).get();
		plantPlanRepository.save(plantPlan.removePlantPlanItem(plantPlanItem));
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@ResponseBody
	@GetMapping(value = "/api/report/plantplan/{plantPlanId}/zipcode/{zipcode}")
	public HttpEntity<Report> presetPlantPlanReportAPi(@PathVariable("plantPlanId") Long plantPlanId, @PathVariable("zipcode") String zipcode, Model model) {
		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);
		Report report = new Report(zipCodeRepo.findOneByZipcode(zipcode));
		report.createReportItemsFromPlantPlan(plantPlan);
		
		model.addAttribute("report" , report);
		model.addAttribute("reportItemSowDateComp", Comparator.comparing(ReportItem::getRequestedSowDate));
		return new ResponseEntity<>(report, HttpStatus.OK);
	}
	//
	
	@GetMapping(value = "/plantplan/{plantPlanId}")
	public String presetPlantPlan(@PathVariable("plantPlanId") Long plantPlanId, Model model) {
		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);
		model.addAttribute("plantPlanItems" , plantPlan.getPlantPlanItems());	
		model.addAttribute("plantNameComp", Comparator.comparing(PlantPlanItem::getPlantName).reversed());
		return "plantplan";
	}
	
	@GetMapping(value = "/report/plantplan/{plantPlanId}/zipcode/{zipcode}")
	public String presetPlantPlanReport(@PathVariable("plantPlanId") Long plantPlanId, @PathVariable("zipcode") String zipcode, Model model) {
		PlantPlan plantPlan = plantPlanRepository.findOne(plantPlanId);
		Report report = new Report(zipCodeRepo.findOneByZipcode(zipcode));
		report.createReportItemsFromPlantPlan(plantPlan);
		
		model.addAttribute("report" , report);
		model.addAttribute("reportItemSowDateComp", Comparator.comparing(ReportItem::getRequestedSowDate));
		return "reporttest";
	}
	
	
}

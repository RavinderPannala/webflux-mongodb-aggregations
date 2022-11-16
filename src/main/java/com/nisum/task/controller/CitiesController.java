package com.nisum.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.task.entity.Cities;
import com.nisum.task.service.CityService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cities")
public class CitiesController {

	@Autowired
	private CityService cityService;

	@PostMapping("/createCity")
	public Mono<Cities> saveCity(@RequestBody Cities city) {
		return cityService.createCity(city);
	}

	@GetMapping("/findAll")
	public Flux<Cities> getAllCities() {
		return cityService.findAll();
	}

	@GetMapping("/findByCitiesInContinent")
	public Flux<Cities> findAllCities() {
		return cityService.getAllCities();
	}

	@GetMapping("/findCitiesByPopulation")
	public Flux<Cities> findAllCitiesByPopulation() {
		return cityService.citiesByPopulation();
	}

	@GetMapping("/findCitiesBySorting")
	public Flux<Cities> findCitiesBySorting() {
		return cityService.sortByPopulation();
	}

}

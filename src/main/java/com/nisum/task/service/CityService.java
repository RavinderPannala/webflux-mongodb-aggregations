package com.nisum.task.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.nisum.task.entity.Cities;
import com.nisum.task.repository.CityRepository;
import com.nisum.task.util.CustomAggregationOperation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	public Flux<Cities> findAll() {

		return cityRepository.findAll();
	}

	public Flux<Cities> getAllCities() {

		AggregationOperation match = Aggregation.match(Criteria.where("continent").in("Asia", "North America"));
		AggregationOperation group = Aggregation.group("$_id").first("$name").as("name");
		AggregationOperation sort = Aggregation.sort(Sort.by(Collections.singletonList(Sort.Order.asc("name"))));

		List<AggregationOperation> operations = new ArrayList<>();
		operations.add(match);
		operations.add(group);
		operations.add(sort);
		// operations.add(max);
		Aggregation aggregation = Aggregation.newAggregation(operations);
		Flux<Cities> allCities = mongoTemplate.aggregate(aggregation, Cities.class, Cities.class);

		return allCities;
	}

	public Mono<Cities> createCity(Cities city) {
		return cityRepository.save(city);
	}

	public Flux<Cities> citiesByPopulation() {

		String query1 = "{$match:{'continent':{$in:['Europe','North America']}}},"
				+ "{$group:{'_id':'$continent',population:{$sum:'$population'}}}," + "{$sort:{'population':-1}}";

		TypedAggregation<Cities> aggregation = Aggregation.newAggregation(Cities.class,
				new CustomAggregationOperation(query1));
		Flux<Cities> allCities = mongoTemplate.aggregate(aggregation, Cities.class, Cities.class);
		return allCities;
	}

	public Flux<Cities> sortByPopulation() {
		return cityRepository.findMaxPopulation();
	}

}

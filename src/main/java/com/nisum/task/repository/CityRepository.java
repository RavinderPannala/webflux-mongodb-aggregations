package com.nisum.task.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nisum.task.entity.Cities;

import reactor.core.publisher.Flux;

@Repository
public interface CityRepository extends ReactiveMongoRepository<Cities, Long>{

	@Aggregation(pipeline = {
		    "{$match:{'continent':'South America'}}",
		})
	Flux<Cities> findMaxPopulation();
}

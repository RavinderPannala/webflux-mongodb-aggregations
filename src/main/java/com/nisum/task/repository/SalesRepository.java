package com.nisum.task.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nisum.task.entity.Sales;

import reactor.core.publisher.Flux;

@Repository
public interface SalesRepository extends ReactiveMongoRepository<Sales, Long>{

	Flux<Sales> findByPurchaseMethodAndStoreLocation(String mode, String location);
	

}

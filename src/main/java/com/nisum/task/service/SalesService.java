package com.nisum.task.service;

import java.util.Arrays;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.reactivestreams.client.AggregatePublisher;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.mongodb.reactivestreams.client.MongoDatabase;
import com.nisum.task.entity.Sales;
import com.nisum.task.repository.SalesRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SalesService {

	@Autowired
	private SalesRepository salesRepository;
	
	//@Autowired
	//private ReactiveMongoTemplate mongoTemplate;
	
	//@Autowired
	//private MongoClient mongoClient;

	public Mono<Sales> addSale(Sales sale) {
		return salesRepository.save(sale);
	}

	public Mono<Sales> findById(Long saleId) {
		return salesRepository.findById(saleId);
	}

	public Flux<Sales> findAllSales() {
		return salesRepository.findAll();
	}
	
	public Flux<Document> searchByPurchaseModes(String purchaseMode, String location) {

		MongoClient mongoClient = MongoClients
				.create("mongodb+srv://sridharyadav589:9640037146@testcluster.bl9klfi.mongodb.net/test");

		MongoDatabase database = mongoClient.getDatabase("sample_supplies");
		MongoCollection<Document> collection = database.getCollection("sales");

//		AggregatePublisher<Document> result = collection.aggregate(Arrays.asList(
//				new Document("$search", 
//			    new Document("index", "default")
//	            .append("text", 
//	    new Document("query", "{\"purchaseMethod\":\"Online\"}")
//	                .append("path",  new Document("wildcard", "*")))), 
//	    new Document("$limit", 8L), 
//	    new Document("$sort",  new Document("storeLocation", 1L))));
		
		AggregatePublisher<Document> result = collection
				.aggregate(
						Arrays.asList(
								new Document("$search",
										new Document("index", "default").append("text",
												new Document("query",
														"{\"purchaseMethod\":\"online\",\"storeLocation\":\"Denver\"}")
																.append("path", new Document("wildcard", "*")))),
								new Document("$limit", 10L)));
		
		
		Flux<Document> list = Flux.from(result);

		return list;
	}
	
	public Flux<Sales> findByPurchaseModeAndLocation(String mode,String location) {
		return salesRepository.findByPurchaseMethodAndStoreLocation(mode,location);
	}

}

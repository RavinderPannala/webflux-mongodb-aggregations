package com.nisum.task.controller;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.task.entity.Sales;
import com.nisum.task.service.SalesService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sales")
public class SalesController {

	@Autowired
	private SalesService salesService;

	@PostMapping("/addSale")
	public Mono<Sales> addSale(@RequestBody Sales sale) {

		return salesService.addSale(sale);
	}

	@GetMapping("/findById/{saleId}")
	public Mono<Sales> getSale(@PathVariable String saleId) {
		return salesService.findById(Long.valueOf(saleId));
	}

	@GetMapping("/findAllSales")
	public Flux<Sales> findSales() {
		return salesService.findAllSales();
	}
	
	@GetMapping("/searchBy/{mode}/{location}")
	public Flux<Document> findSalesByLocation(@PathVariable String mode,@PathVariable String location) {
		return salesService.searchByPurchaseModes(mode,location);
	}
	
	@GetMapping("/searchByLocation/{mode}/{location}")
	public Flux<Sales> findByLocation(@PathVariable String mode,@PathVariable String location) {
		return salesService.findByPurchaseModeAndLocation(mode,location);
	}

}

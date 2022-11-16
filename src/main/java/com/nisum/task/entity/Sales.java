package com.nisum.task.entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sales {

	
	private ObjectId _id;
	private String storeLocation;
	private boolean couponUsed;
	private String purchaseMethod;
	private Customer customer;
	private List<Items> items;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public boolean isCouponUsed() {
		return couponUsed;
	}
	public void setCouponUsed(boolean couponUsed) {
		this.couponUsed = couponUsed;
	}
	public String getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(String purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	
}

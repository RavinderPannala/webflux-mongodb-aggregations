package com.nisum.task.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

	private ObjectId _id;
	private String email;
	private String gender;
	private String age;
	private Integer satisfaction;
	
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(Integer satisfaction) {
		this.satisfaction = satisfaction;
	}
	@Override
	public String toString() {
		return "Customer [_id=" + _id + ", email=" + email + ", gender=" + gender + ", age=" + age + ", satisfaction="
				+ satisfaction + "]";
	}
	
}

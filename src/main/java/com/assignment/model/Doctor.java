package com.assignment.model;

public class Doctor {
	
	private int id;
	private String name;
	private String email;
	private String category;
	private String experience;
	private String location;
	private int fee;
	
	public Doctor() {
		
	}



	public Doctor(int id, String name, String category, String location) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.location = location;
	}



	public Doctor(int id, String name, String email, String category, String experience, String location,
			int fee) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.category = category;
		this.experience = experience;
		this.location = location;
		this.fee = fee;
	}



	public Doctor(String name, String email, String category, String experience, String location,
			int fee) {
		super();
		this.name = name;
		this.email = email;
		this.category = category;
		this.experience = experience;
		this.location = location;
		this.fee = fee;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	

	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	

}

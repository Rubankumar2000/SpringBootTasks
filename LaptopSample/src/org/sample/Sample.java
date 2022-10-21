package org.sample;

public class Sample {
	private int id;
	private String model;
	private String brand;
	private String date;
	private String city;
	
//	public Sample() {
//		super();
//	}
	public Sample(String model, String brand, String date, String city) {
		super();
		this.model = model;
		this.brand = brand;
		this.date = date;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}

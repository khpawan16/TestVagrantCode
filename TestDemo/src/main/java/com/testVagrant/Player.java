package com.testVagrant;

import com.google.gson.annotations.SerializedName;

public class Player {
	String name;
	String country;
	String role;
	@SerializedName("price-in-crores")
	String price_in_crores;
	
	public String getPrice_in_crores() {
		return price_in_crores;
	}
	public void setPrice_in_crores(String price_in_crores) {
		this.price_in_crores = price_in_crores;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

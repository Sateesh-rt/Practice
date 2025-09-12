package com.oneToMany.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Theater {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String place;
	private float ratings;
	@OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
	private List<Screens> screens;
	@OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
	private List<Shops>   shops;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public List<Screens> getScreens() {
		return screens;
	}
	public void setScreens(List<Screens> screens) {
		this.screens = screens;
		if(screens!=null) {
			screens.forEach(add->add.setTheater(this));
		}
	}
	public List<Shops> getShops() {
		return shops;
	}
	public void setShops(List<Shops> shops) {
		this.shops = shops;
		if(shops!=null) {
			shops.forEach(add->add.setTheater(this));
		}
	}
	

}

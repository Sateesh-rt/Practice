package com.example.map.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String carname;
private int carno;
private String carcolour;
@ManyToOne
private User user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCarname() {
	return carname;
}
public void setCarname(String carname) {
	this.carname = carname;
}
public int getCarno() {
	return carno;
}
public void setCarno(int carno) {
	this.carno = carno;
}
public String getCarcolour() {
	return carcolour;
}
public void setCarcolour(String carcolour) {
	this.carcolour = carcolour;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}

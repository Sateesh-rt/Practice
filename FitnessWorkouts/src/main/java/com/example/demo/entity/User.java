package com.example.demo.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
	@JoinColumn(name="user_Goal")
	private List<Workout> workout;
	
	@OneToMany(mappedBy = "user", cascade =CascadeType.ALL)
	private List<Goal> goal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Workout> getWorkout() {
		return workout;
	}

	public void setWorkout(List<Workout> workout) {
		this.workout = workout;
		if(workout!=null) {
			workout.forEach(w->w.setUser(this));
		}
	}

	public List<Goal> getGoal() {
		return goal;
	}

	public void setGoal(List<Goal> goal) {
		this.goal = goal;
		if(goal!=null) {
			goal.forEach(g->g.setUser(this));
		}
	}
	
	
	
	
}

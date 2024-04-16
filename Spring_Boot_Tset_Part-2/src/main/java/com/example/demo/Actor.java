package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Actor(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

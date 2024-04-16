package com.example.demo;


import jakarta.persistence.*;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	
	@ManyToOne
	private Actor actor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film(String title, Actor actor) {
		super();
		this.title = title;
		this.actor = actor;
	}

	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
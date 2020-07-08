package com.microservice.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sport")
public class Sport {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="play")
	private String play;
	
	@Column(name="watch")
	private String watch;
	
	public Sport() {}
	
	

	public Sport(String play, String watch) {
		
		this.play = play;
		this.watch = watch;
	}



	public Long getId() {
		return id;
	}

	

	public String getPlay() {
		return play;
	}

	public void setPlay(String play) {
		this.play = play;
	}

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
	}
	
	
}

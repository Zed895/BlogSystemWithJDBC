package com.blogsystemwithjdbc.domain;

import java.util.List;
//import com.fasterxml.jackson.annotation.JsonBackReference;

/**
* This class represents a blogger entity in the DB.
* @author Zed
*/

public class Blogger {
	
	private Long id; //private, encapsulated
	private String name;
	private int age;
	private List<Story> stories; //A blogger could have more stories in this list.
	
	/**
	 * Constructor to create a blogger object.
	 */
	private Blogger() {
	}	
	
	/**
	 * Constructor to create a blogger object from the View, instead of the SQL files.
	 * @param name the name of the new blogger
	 * @param age the age of the new blogger
	 */
	public Blogger(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Constructor to create a blogger object by JDBC.
	 * @param id the id of the new blogger in the DB.
	 * @param name the name of the new blogger
	 * @param age the age of the new blogger
	 */
	public Blogger(Long id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	//getters and setters
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	
	//For debug
//	@Override
//	public String toString() {
//		return "Blogger [id=" + id + ", name=" + name + ", age=" + age + ", stories=" + stories + "]";
//	}
	
}

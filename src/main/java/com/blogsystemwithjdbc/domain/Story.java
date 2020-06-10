package com.blogsystemwithjdbc.domain;

import java.util.Date;

/**
* This class represents a story entity in the DB.
* @author Zed
*/
public class Story {	
	
	private Long id;
	private String title;
	private String content;
	private Date posted;
	private Blogger blogger;
	
	/**
	 * Constructor to create a story object via JDBC.
	 * Called by storyRepo's findByTitle(String title). Needed by the rawmapper.
	 */
	public Story() {
	}
	
	/**
	 * Constructor to create a story object from the View, not from the SQL files.
	 * @param title the title of the new story
	 * @param content the content of the new story
	 * @param posted the date when it was posted
	 * @param blogger the name of the blogger who posted the new story
	 */
	public Story(String title, String content, Date posted, Blogger blogger) {												
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = blogger;
	}

	/**
	 * Constructor to create a story object by the JDBC.
	 * Called by the lambda solution in the storyRepo's findAll() function.
	 * @param id the id of the new story
	 * @param title the title of the new story
	 * @param content the content of the new story
	 * @param posted the date when it was posted
	 * @param bloggerId the id of the blogger who posted the new story
	 * @param bloggerName the name of the blogger who posted the new story
	 * @param bloggerAge the age of the blogger who posted the new story
	 */
	public Story(Long id, String title, String content, Date posted, Long bloggerId, String bloggerName, int bloggerAge) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = new Blogger(bloggerId, bloggerName, bloggerAge);
	}
	
	//getters and setters
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPosted() {
		return posted;
	}
	public void setPosted(Date posted) {
		this.posted = posted;
	}
	public Blogger getBlogger() {
		return blogger;
	}
	public void setBlogger(Blogger author) {
		this.blogger = author;
	}

//	@Override
//	public String toString() {
//		return "Story [title=" + title + "]";
//	}

}

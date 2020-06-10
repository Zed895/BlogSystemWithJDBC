package com.blogsystemwithjdbc.service;

//import java.util.Date;
import java.util.List;
//import javax.annotation.PostConstruct;
//import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogsystemwithjdbc.domain.Blogger;
import com.blogsystemwithjdbc.domain.Story;
import com.blogsystemwithjdbc.repository.BloggerRepository;
import com.blogsystemwithjdbc.repository.StoryRepository;

/**
 * This class is the Service layer for business logic, calculations.
 * It is Singleton, since service.
 * Always the same will be injected regardless who sees how many times the webpage, everybody receives the same single service.
 * @author Zed
 */
@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	private BloggerRepository bloggerRepo;
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}
	
	/**
	 * Returns the stories from the repo.
	 * @return all of the stories
	 */
	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	/**
	 * Returns a blogger specified by its id from the repo.
	 * @param id the id of the required blogger in the DB
	 * @return the required blogger object
	 */
	public Blogger getBlogger(Long id) {
		return bloggerRepo.findBlogger(id).get(0);
	}
	
	/**
	 * Returns all of the bloggers from the repo.
	 * @return a List containing all of the bloggers
	 */
	public List<Blogger> getBloggers() {
		return bloggerRepo.findAllBlogger();
	}
	
//	/**
//	 * Returns the first story (by posted time) from the repo.
//	 * @return a single story.
//	 */
//	public Story getStory() {
//		return storyRepo.findFirstByOrderByPostedDesc();
//	}
	
	/**
	 * Returns a story with the requested title from the repo.
	 * @param title a story title
	 * @return a specific story.
	 */
	public Story getSpecificStory(String title) { //check later if it is null then exception handling.
		return storyRepo.findByTitle(title);
	}
	
//	/**
//	 * Returns all of the stories written by the same blogger from the repo.
//	 * @param name a blogger name
//	 * @return stories.
//	 */
//	public List<Story> getStoriesByBloggerName(String name) {
//		return storyRepo.findAllByBloggerNameIgnoreCaseOrderByPostedDesc(name);
//	}
	
//	/**
//	 * Container calls it once when the service is intantiated.
//	 * Creates a story and a blogger in the HEAP, then JPA saves it via extended CrudRepository.
//	 */
//	@PostConstruct
//	public void init() {
//		Blogger blogger = new Blogger("Inner John", 25); //not from the Container but theoretically from the users.
//		bloggerRepo.save(blogger);
//		Story story = new Story("Inner title from code", "Inner content from code", new Date(), blogger);
//		storyRepo.save(story);
//	}

}

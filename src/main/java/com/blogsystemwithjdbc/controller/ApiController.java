package com.blogsystemwithjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogsystemwithjdbc.domain.Blogger;
import com.blogsystemwithjdbc.service.StoryService;

/**
* This class is a RestController layer, when a specific request arrives it sends back raw data.
* @author Zed
*/
@RestController
public class ApiController {
	
	private StoryService storyService;
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	/**
	 * If a request arrives to the "/blogger/" URL followed by an id param then it returns the blogger with the given ID from the DB.
	 * @param id the id of a blogger from the request
	 * @return the requested blogger.
	 */
	@RequestMapping("/blogger/{id}")
	public Blogger searchForBlogger(@PathVariable(value="id") Long id) {
		return storyService.getBlogger(id);
	}
	
	/**
	 * If a request arrives to the "/bloggers" URL then it returns a list of bloggers as raw data.
	 * @return all the bloggers as raw data.
	 */
	@RequestMapping("/bloggers")
	public List<Blogger> searchForBloggers() {
		return storyService.getBloggers();
	}
	
	
//	/**
//	 * If a request arrives to the "/story" URL then it returns the newest story object.
//	 * @return the newest story.
//	 */
//	@RequestMapping("/story")
//	public Story story() {//model removed, it does not go the the frontend now.
//		return storyService.getStory();
//		//return storyService.getStory().toString(); //to get it as a String
//	}
//	
//	/**
//	 * If a request arrives to the "/stories/" URL then it returns the stories written by the specified blogger.
//	 * It gets them from the storyRepo, it filters by blogger.
//	 * @param name the name of the blogger.
//	 * @return the stories written by the same blogger.
//	 */
//	@RequestMapping("/stories/{name}")
//	public List<Story> searchStoriesByBloggerName(@PathVariable(value="name") String name){
//		return storyService.getStoriesByBloggerName(name);
//	}

}

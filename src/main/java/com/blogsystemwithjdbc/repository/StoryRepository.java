package com.blogsystemwithjdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.blogsystemwithjdbc.domain.Blogger;
import com.blogsystemwithjdbc.domain.Story;
import com.blogsystemwithjdbc.service.StoryService;

/**
* This class is a Repository layer, part of the model, communicates with the DB.
* @author Zed
*/
@Repository //it shows to the framework that it is part of the model layer connecting to the DB.
public class StoryRepository {
	private JdbcTemplate jdbc; //the imported jdbc jar from a library of the Spring framework
	
	@Autowired
	public StoryRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	@Autowired
	private StoryService storyService;
	
	/**
	 * It selects all of the records from the story table of the DB representing a story object ordered by posted date.
	 * Then it creates the story objects.
	 * @return all of the story objects from the DB.
	 */
	public List<Story> findAll() {
		String sql = "select * from story order by posted desc";
		return jdbc.query(sql, (rs,i) -> new Story(
				rs.getLong("id"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getDate("posted"),
				rs.getLong("blogger_id"),
				storyService.getBlogger(rs.getLong("blogger_id")).getName(),
				storyService.getBlogger(rs.getLong("blogger_id")).getAge()
				)); //2nd param, the lambda: how to turn the received raw data to objects on a springboot jdbc way.
	}
	
	/**
	 * It selects record from the story table of the DB representing story object specified by its title.
	 * Then it creates story object.
	 * @param title the title of the required story
	 * @return the requested story object.
	 */
	public Story findByTitle(String title) { //old method without lambda
		String sql = "select * from story where title = ? order by posted";
		return jdbc.queryForObject(
				sql,
				new Object[]{title},
				new RowMapper<Story>() {
					public Story mapRow(ResultSet rs, int rowNum) throws SQLException {
						Story story = new Story(); //uses the empty constructor and setters.
						story.setId(rs.getLong("id"));
						story.setTitle(rs.getString("title"));
						story.setContent(rs.getString("content"));
						story.setPosted(rs.getDate("posted"));
						story.setBlogger(new Blogger (rs.getLong("blogger_id"), storyService.getBlogger(rs.getLong("blogger_id")).getName(), storyService.getBlogger(rs.getLong("blogger_id")).getAge()));
						return story;
					}
				}
		);
	}

}

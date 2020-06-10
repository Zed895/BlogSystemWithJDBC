package com.blogsystemwithjdbc.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.blogsystemwithjdbc.domain.Blogger;

/**
* This class is a Repository layer, part of the model, communicates with the DB.
* @author Zed
*/
@Repository
public class BloggerRepository {
	private JdbcTemplate jdbc; //the imported jdbc jar from a library of the Spring framework
	
	@Autowired
	public BloggerRepository(JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}

	/**
	 * It selects all of the records from the blogger table of the DB representing a blogger object ordered by their id number.
	 * Then it creates the blogger objects.
	 * @return all of the blogger objects from the DB.
	 */
	public List<Blogger> findAllBlogger() {
		String sql = "select * from blogger order by id";
		return jdbc.query(sql, (rs,i) -> new Blogger(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age")
				));
	}
	
	/**
	 * It selects a record from the blogger table of the DB representing a blogger object specified by its id number.
	 * Then it creates the blogger object.
	 * @param id the id number of the required blogger
	 * @return a single blogger object in a List.
	 */
	public List<Blogger> findBlogger(Long id) {
		String sql = "select * from blogger where id = "+ id; //Long could not be substituted by '?'.
		return jdbc.query(sql, (rs,i) -> new Blogger(
				rs.getLong("id"),
				rs.getString("name"),
				rs.getInt("age")
				));
	}
}

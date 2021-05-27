package thedarkdnktv.springtrial.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import thedarkdnktv.springtrial.mvc.models.Person;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class PersonDAO {

	private final JdbcTemplate template;
	
	@Autowired
	public PersonDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	public List<Person> index() {
		return template.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
	}
	
	public Person show(int id) {
		return template.query("SELECT * FROM Person WHERE id=?", new BeanPropertyRowMapper<>(Person.class), new Object[] {id})
				.stream()
				.findAny()
				.orElse(null);
	}
	
	public void save(Person person) {
		template.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getAge(), person.getEmail());
	}
	
	public void update(int id, Person person) {
		template.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?", person.getName(), person.getAge(), person.getEmail(), id);
	}
	
	public void delete(int id) {
		template.update("DELETE FROM Person WHERE id=?", id);
	}
}

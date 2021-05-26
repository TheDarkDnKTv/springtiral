package thedarkdnktv.springtrial.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import thedarkdnktv.springtrial.mvc.models.Person;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class PersonDAO {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
	private static final String USER = "postgres";
	private static final String PASS = "testpass";
	
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> index() {
		List<Person> people = new ArrayList<>();
		
		try {
			Statement state = connection.createStatement();
			String SQL = "SELECT * FROM Person";
			ResultSet result = state.executeQuery(SQL);
			
			while (result.next()) {
				Person person = new Person();
				{
					person.setId(result.getInt("id"));
					person.setName(result.getString("name"));
					person.setAge(result.getInt("age"));
					person.setEmail(result.getString("email"));
				}
				people.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return people;
	}
	
	public Person show(int id) {
		return null;
//		return people.stream().
//				filter(p -> p.getId() == id)
//				.findAny()
//				.orElse(null);
	}
	
	public void save(Person person) {
		try {
			Statement state = connection.createStatement();
			String SQL = String.format("INSERT INTO Person VALUES(%d, '%s', %d, '%s')", 1, person.getName(), person.getAge(), person.getEmail());
			state.executeUpdate(SQL);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int id, Person person) {
//		Person p = people.get(id);
//		p.setName(person.getName());
//		p.setAge(person.getAge());
//		p.setEmail(person.getEmail());
	}
	
	public void delete(int id) {
//		people.removeIf(p -> p.getId() == id);
	}
}

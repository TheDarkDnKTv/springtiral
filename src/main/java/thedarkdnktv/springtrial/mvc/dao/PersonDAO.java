package thedarkdnktv.springtrial.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		Person result = null;
		
		try {
			PreparedStatement state = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
			state.setInt(1, id);
			ResultSet vals = state.executeQuery();
			
			vals.next(); // TODO ids
			
			result = new Person();
			result.setId(vals.getInt("id"));
			result.setName(vals.getString("name"));
			result.setAge(vals.getInt("age"));
			result.setEmail(vals.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void save(Person person) {
		try {
			PreparedStatement state =  connection.prepareStatement("INSERT INTO Person VALUES(1, ?, ?, ?)");
			state.setString(1, person.getName());
			state.setInt(2, person.getAge());
			state.setString(3, person.getEmail());
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(int id, Person person) {
		try {
			PreparedStatement state = connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
			state.setString(1, person.getName());
			state.setInt(2, person.getAge());
			state.setString(3, person.getEmail());
			state.setInt(4, id);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement state = connection.prepareStatement("DELETE FROM Person WHERE id=?");
			state.setInt(1, id);
			state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

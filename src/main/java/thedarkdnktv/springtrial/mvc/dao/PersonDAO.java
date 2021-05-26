package thedarkdnktv.springtrial.mvc.dao;

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
	
	private List<Person> people;
	
	{
		people = new ArrayList<>();
		
		people.add(new Person(people.size(), "Tom"));
		people.add(new Person(people.size(), "Bob"));
		people.add(new Person(people.size(), "Mike"));
		people.add(new Person(people.size(), "Katy"));
	}
	
	public List<Person> index() {
		return people;
	}
	
	public Person show(int id) {
		return people.stream().
				filter(p -> p.getId() == id)
				.findAny()
				.orElse(null);
	}
	
	public void save(Person person) {
		person.setId(people.size());
		people.add(person);
	}
	
	public void update(int id, Person person) {
		Person p = people.get(id);
		p.setName(person.getName());
	}
	
	public void delete(int id) {
		if (id >= 0 && id < people.size()) {
			people.remove(id);
		}
	}
}

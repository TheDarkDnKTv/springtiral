package thedarkdnktv.springtrial.mvc.dao;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import thedarkdnktv.springtrial.mvc.models.Person;

/**
 * @author TheDarkDnKTv
 *
 */
@Component
public class PersonDAO {

	private final SessionFactory factory;
	
	@Autowired
	public PersonDAO(LocalSessionFactoryBean factory) {
		this.factory = factory.getObject();
	}
	
	public List<Person> index() {
		try (Session session = factory.openSession()) {
			CriteriaQuery<Person> query = session.getCriteriaBuilder().createQuery(Person.class);
			query.from(Person.class);
			Query<Person> qq = session.createQuery(query);
			return qq.getResultList();
		}
	}
	
	public Person show(int id) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			Person ret = session.get(Person.class, id); // Getting object by id
			session.getTransaction().commit();
			return ret;
		}
	}
	
	public void save(Person person) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			session.save(person);
			session.getTransaction().commit();
		}
	}
	
	public void update(int id, Person person) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			person.setId(id);
			session.merge(person);
			session.getTransaction().commit();
		}
	}
	
	public void delete(int id) {
		try (Session session = factory.openSession()) {
			session.beginTransaction();
			Person person = session.get(Person.class, id);
			session.delete(person);
			session.getTransaction().commit();
		}		
	}
	
	@PreDestroy
	public void deconstruct() {
		factory.close();
	}
}

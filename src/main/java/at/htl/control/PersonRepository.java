package at.htl.control;

import at.htl.model.Location;
import at.htl.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @Inject
    EntityManager em;

    public void delete(Person person) {
        em.remove(person);
    }

    public void save(Person person){
        em.merge(person);
    }

    public List<Person> findAll() {
        return em
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
    }

}

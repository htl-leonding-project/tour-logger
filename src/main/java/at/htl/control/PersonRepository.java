package at.htl.control;

import at.htl.model.Location;
import at.htl.model.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PersonRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Person person) {
        em.remove(person);
    }

    @Transactional
    public void save(Person person){
        em.merge(person);
    }

    public List<Person> findAll() {
        return em
                .createNamedQuery("Person.findAll", Person.class)
                .getResultList();
    }

}

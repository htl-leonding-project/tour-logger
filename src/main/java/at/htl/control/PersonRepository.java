package at.htl.control;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class PersonRepository {

    @Inject
    EntityManager em;

}

package at.htl.control;

import at.htl.model.Boat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class BoatRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Boat boat) {
        em.remove(boat);
    }

}

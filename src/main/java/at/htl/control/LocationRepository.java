package at.htl.control;

import at.htl.model.BoatState;
import at.htl.model.Location;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class LocationRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Location location) {
        em.remove(location);
    }

    @Transactional
    public void save(Location location){
        em.merge(location);
    }

}

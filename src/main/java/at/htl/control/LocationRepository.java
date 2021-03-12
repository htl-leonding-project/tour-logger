package at.htl.control;

import at.htl.model.BoatState;
import at.htl.model.Location;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class LocationRepository {

    @Inject
    EntityManager em;

    public void delete(Location location) {
        em.remove(location);
    }

    public void save(Location location){
        em.merge(location);
    }

    public List<Location> findAll() {
        return em
                .createNamedQuery("Location.findAll", Location.class)
                .getResultList();
    }

}

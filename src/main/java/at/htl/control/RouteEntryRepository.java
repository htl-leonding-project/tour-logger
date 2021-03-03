package at.htl.control;

import at.htl.model.BoatState;
import at.htl.model.RouteEntry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class RouteEntryRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(RouteEntry routeEntry) {
        em.remove(routeEntry);
    }

    @Transactional
    public void save(RouteEntry routeEntry){
        em.merge(routeEntry);
    }

}

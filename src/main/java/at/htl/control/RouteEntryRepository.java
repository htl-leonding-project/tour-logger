package at.htl.control;

import at.htl.model.BoatState;
import at.htl.model.RouteEntry;
import io.vertx.ext.web.Route;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<RouteEntry> findAll() {
        return em
                .createNamedQuery("RouteEntry.findAll", RouteEntry.class)
                .getResultList();
    }

}

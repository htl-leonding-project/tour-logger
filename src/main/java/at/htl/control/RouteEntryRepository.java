package at.htl.control;

import at.htl.model.BoatState;
import at.htl.model.RouteEntry;
import io.vertx.ext.web.Route;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class RouteEntryRepository {

    @Inject
    EntityManager em;

    public void delete(RouteEntry routeEntry) {
        em.remove(routeEntry);
    }

    public void save(RouteEntry routeEntry){
        em.merge(routeEntry);
    }

    public List<RouteEntry> findAll() {
        return em
                .createNamedQuery("RouteEntry.findAll", RouteEntry.class)
                .getResultList();
    }

}

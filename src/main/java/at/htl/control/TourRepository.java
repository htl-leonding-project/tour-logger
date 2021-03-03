package at.htl.control;

import at.htl.model.RouteEntry;
import at.htl.model.Tour;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class TourRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Tour tour) {
        em.remove(tour);
    }

    @Transactional
    public void save(Tour tour){
        em.merge(tour);
    }

    public List<Tour> findAll() {
        return em
                .createNamedQuery("Tour.findAll", Tour.class)
                .getResultList();
    }

}

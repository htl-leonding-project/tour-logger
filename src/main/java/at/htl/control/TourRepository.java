package at.htl.control;

import at.htl.model.RouteEntry;
import at.htl.model.Tour;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class TourRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Tour tour) {
        em.remove(tour);
    }

}

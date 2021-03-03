package at.htl.control;

import at.htl.model.Tour;
import at.htl.model.TourState;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class TourStateRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(TourState tourState) {
        em.remove(tourState);
    }



}

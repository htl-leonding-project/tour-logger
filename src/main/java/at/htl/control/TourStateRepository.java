package at.htl.control;

import at.htl.model.Tour;
import at.htl.model.TourState;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class TourStateRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(TourState tourState) {
        em.remove(tourState);
    }

    @Transactional
    public void save(TourState tourState){
        em.merge(tourState);
    }

    public List<TourState> findAll() {
        return em
                .createNamedQuery("TourState.findAll", TourState.class)
                .getResultList();
    }

}

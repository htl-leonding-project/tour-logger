package at.htl.control;

import at.htl.model.Tour;
import at.htl.model.TourState;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped

public class TourStateRepository {

    @Inject
    EntityManager em;


    public void delete(TourState tourState) {
        em.remove(tourState);
    }

    public void save(TourState tourState){
        em.merge(tourState);
    }

    public List<TourState> findAll() {
        return em
                .createNamedQuery("TourState.findAll", TourState.class)
                .getResultList();
    }

}

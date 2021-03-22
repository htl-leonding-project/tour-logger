package at.htl.control;

import at.htl.model.Boat;
import at.htl.model.BoatState;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BoatStateRepository {

    @Inject
    EntityManager em;

    public void delete(BoatState boatState) {
        em.remove(boatState);
    }

    public void save(BoatState boatState){
        em.merge(boatState);
    }

    public List<BoatState> findAll() {
        return em
                .createNamedQuery("Boat_State.findAll", BoatState.class)
                .getResultList();
    }

}

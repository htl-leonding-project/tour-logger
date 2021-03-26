package at.htl.control;

import at.htl.model.Boat;
import at.htl.model.BoatState;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BoatStateRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(BoatState boatState) {
        em.remove(boatState);
    }

    @Transactional
    public void save(BoatState boatState){
        em.merge(boatState);
    }

    public List<BoatState> findAll() {
        return em
                .createNamedQuery("Boat_State.findAll", BoatState.class)
                .getResultList();
    }

    public BoatState findById(Long id){
        var query = em.createQuery("select bs from BoatState bs where bs.id = :id", BoatState.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

}

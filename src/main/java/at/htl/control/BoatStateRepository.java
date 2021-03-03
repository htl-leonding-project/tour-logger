package at.htl.control;

import at.htl.model.BoatState;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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

}

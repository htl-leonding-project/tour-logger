package at.htl.control;

import at.htl.model.Boat;
import at.htl.model.BoatType;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class BoatTypeRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(BoatType boatType) {
        em.remove(boatType);
    }

    @Transactional
    public void save(BoatType boatType){
        em.merge(boatType);
    }

}

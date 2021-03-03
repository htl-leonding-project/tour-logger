package at.htl.control;

import at.htl.model.Boat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class BoatRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void delete(Boat boat) {
        em.remove(boat);
    }

    @Transactional
    public void save(Boat boat){
        em.merge(boat);
    }

    public List<Boat> findAll() {
        return em
                .createNamedQuery("Boat.findAll", Boat.class)
                .getResultList();
    }

}

package at.htl.control;

import at.htl.model.Boat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class BoatRepository {

    @Inject
    EntityManager em;

    public void delete(Boat boat) {
        em.remove(boat);
    }

    public void save(Boat boat){
        em.merge(boat);
    }

    public List<Boat> findAll() {
        return em
                .createNamedQuery("Boat.findAll", Boat.class)
                .getResultList();
    }

}

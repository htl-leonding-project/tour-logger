package at.htl.persistance;

import at.htl.model.Boat;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BoatRepository implements PanacheRepository<Boat> {
}

package at.htl.persistence;

import at.htl.model.Tour;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TourRepository implements PanacheRepository<Tour> {

}

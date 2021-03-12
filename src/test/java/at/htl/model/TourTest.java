package at.htl.model;

import at.htl.misc.DataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
@ApplicationScoped
class TourTest {


    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;


    @Test
    void createTourTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        TourState ts = new TourState("PLANNED");
        BoatState bs = new BoatState("AVAILABLE");
        BoatType bt = new BoatType("KANU");
        Boat b = new Boat("Test", bt, bs);
        Location l = new Location("Donau", 14.285830f, 48.306938f);
        Tour t = new Tour();
        RouteEntry re = new RouteEntry(l, t);
        tm.begin();
        em.persist(ts);
        em.persist(bs);
        em.persist(bt);
        em.persist(b);
        em.persist(l);
        em.persist(t);
        em.persist(re);
        em.persist(new Tour("TEST", ts, b, re));
        tm.commit();
        Table tour = new Table(DataSource.getDataSource(), "TOUR");
        assertThat(tour).row(1)
                .value().isEqualTo(2)
                .value().isEqualTo("TEST")
                .value().isEqualTo(1)
                .value().isEqualTo(1)
                .value().isEqualTo(1);
    }
}

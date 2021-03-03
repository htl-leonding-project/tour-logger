package at.htl.modelTest;

import at.htl.misc.DataSource;
import at.htl.model.Location;
import at.htl.model.RouteEntry;
import at.htl.model.Tour;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@ApplicationScoped
class RouteEntryTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createRouteEntryTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Location l = new Location("Donau", 14.285830f, 48.306938f);
        Tour t = new Tour();
        tm.begin();
        em.persist(l);
        em.persist(t);
        em.persist(new RouteEntry(l, t));
        tm.commit();
        Table routeEntry = new Table(DataSource.getDataSource(), "ROUTE_ENTRY");
        assertThat(routeEntry).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo(1)
                .value().isEqualTo(1);

    }

}

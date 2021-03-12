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
class TourStateTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;


    @Test
    void createTourStateTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        TourState ts = new TourState("PLANNED");
        tm.begin();
        em.persist(ts);
        tm.commit();
        Table tourState = new Table(DataSource.getDataSource(), "TOUR_STATE");
        assertThat(tourState).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("PLANNED");
    }
}

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
class BoatTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createBoatTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        BoatState bs = new BoatState("AVAILABLE");
        BoatType bt = new BoatType("KANU");
        tm.begin();
        em.persist(bs);
        em.persist(bt);
        em.persist(new Boat("Test", bt, bs));
        tm.commit();
        Table boat = new Table(DataSource.getDataSource(), "BOAT");
        assertThat(boat).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("Test")
                .value().isEqualTo(1)
                .value().isEqualTo(1);
    }

}

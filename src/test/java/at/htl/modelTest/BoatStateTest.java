package at.htl.modelTest;

import at.htl.misc.DataSource;
import at.htl.model.BoatState;
import at.htl.model.BoatType;
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
class BoatStateTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createPersonTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        BoatState bs = new BoatState("AVAILABLE");
        tm.begin();
        em.persist(bs);
        tm.commit();
        Table boatState = new Table(DataSource.getDataSource(), "BOAT_STATE");
        assertThat(boatState).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("AVAILABLE");
    }
}

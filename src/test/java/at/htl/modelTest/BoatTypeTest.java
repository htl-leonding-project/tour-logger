package at.htl.modelTest;

import at.htl.misc.DataSource;
import at.htl.model.BoatType;

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
class BoatTypeTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createPersonTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        BoatType bt = new BoatType("Kanu");
        tm.begin();
        em.persist(bt);
        tm.commit();
        Table boatType = new Table(DataSource.getDataSource(), "BOAT_TYPE");
        assertThat(boatType).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("Kanu");
    }

}

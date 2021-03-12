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
class LocationTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createLocationTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Location l = new Location("Donau", 14.285830f, 48.306938f);
        tm.begin();
        em.persist(l);
        tm.commit();
        Table location = new Table(DataSource.getDataSource(), "LOCATION");
        assertThat(location).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("Donau")
                .value().isEqualTo(48.306938f)
                .value().isEqualTo(14.285830f);
    }
}

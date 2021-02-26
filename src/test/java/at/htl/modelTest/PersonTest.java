package at.htl.modelTest;

import at.htl.misc.DataSource;
import at.htl.model.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@ApplicationScoped
class PersonTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;


    @Test
    void createPersonTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        Person p = new Person("Günther", LocalDate.of(1999, Month.APRIL, 25), "test");
        tm.begin();
        em.persist(p);
        tm.commit();
        Table person = new Table(DataSource.getDataSource(), "PERSON");
        assertThat(person).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo(LocalDate.of(1999, Month.APRIL, 25))
                .value().isEqualTo("Günther")
                .value().isEqualTo("test");
    }

}

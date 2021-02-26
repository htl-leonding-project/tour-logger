package at.htl.model;

import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.*;

import java.at.htl.model.Person;
import java.time.LocalDate;
import java.time.Month;

import static org.assertj.db.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class PersonTest {

    @Inject
    EntityManager em;
    @Inject
    UserTransaction tm;

    @Test
    void createTeacherTest() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        java.at.htl.model.Person p = new Person("Günther", LocalDate.of(1999, Month.APRIL, 25), "test");
        em.persist(p);
        Table person = new Table(DataSource.getDataSource(), "person");
        assertThat(person).row(0)
                .value().isEqualTo(1)
                .value().isEqualTo("Teach")
                .value().isEqualTo(1);
    }

}

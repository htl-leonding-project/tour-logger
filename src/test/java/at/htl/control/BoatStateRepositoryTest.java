package at.htl.control;

import at.htl.misc.DataSource;
import at.htl.model.Boat;
import at.htl.model.BoatState;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.type.Table;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.List;

import static at.htl.misc.DataSource.getDataSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.db.output.Outputs.output;


@QuarkusTest
class BoatStateRepositoryTest {

    @Inject
    BoatStateRepository bsr;

    @Test
    void findByIdTest(){
        bsr.save(new BoatState("STATE"));

        BoatState foundState = bsr.findById(1L);

        Table boatState = new Table(getDataSource(), "boat_State");
        output(boatState).toConsole();

        //assertThat(foundPerson.getFirstName()).isEqualTo("madschi");
        assertThat(foundState.getState()).isEqualTo("STATE");

    }

    @Test
    void findAllTest(){
        Table boatStateTable = new Table(getDataSource(), "boat_state");
        output(boatStateTable).toConsole();

        bsr.save(new BoatState("STATE1"));
        bsr.save(new BoatState("STATE2"));
        bsr.save(new BoatState("STATE3"));

        boatStateTable = new Table(getDataSource(), "boat_state");
        output(boatStateTable).toConsole();

        List<BoatState> boatStateList = bsr.findAll();

        assertThat(boatStateList.size()).isEqualTo(3);

    }

}
package at.htl.control;

import at.htl.misc.DataSource;
import at.htl.model.BoatState;
import io.quarkus.test.junit.QuarkusTest;
import org.assertj.db.api.Assertions;
import org.assertj.db.type.Table;
import org.assertj.db.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



@QuarkusTest
class BoatStateRepositoryTest {

    BoatStateRepository bsr = new BoatStateRepository();


    Table boatState = new Table(DataSource.getDataSource(), "boat_state");



    @Test
    void createTest(){
        //arrange
        BoatState testState = new BoatState("TESTSTATE");
        //act
        bsr.save(testState);
        Table boatState = new Table(DataSource.getDataSource(), "boat_state");
        //assert
        Assertions.assertThat(boatState).row()
                .value(1)
                .value("TESTSTATE");


    }

}
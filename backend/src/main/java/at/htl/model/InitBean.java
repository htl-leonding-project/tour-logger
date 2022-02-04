package at.htl.model;

import at.htl.persistance.BoatRepository;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@ApplicationScoped
public class InitBean{

    final String FILE_NAME = "src/main/resources/boats.csv";

    @Inject
    BoatRepository br;

    @Transactional
    void onStart(@Observes StartupEvent event) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

        reader.lines().skip(1)
                .distinct()
                .map(x -> x.split("\\|"))
                .peek(x -> {
                    //System.out.printf("%s: %s\n", x[1], x[9]);
                    Boat boat = new Boat(x[1], x[9]);
                    br.persist(boat);
                })
                .count();
    }

}

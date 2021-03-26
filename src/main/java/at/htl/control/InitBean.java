package at.htl.control;

import at.htl.model.*;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.time.LocalDate;

@ApplicationScoped
public class InitBean {

    @Inject
    BoatRepository boatRepository;
    @Inject
    BoatStateRepository boatStateRepository;
    @Inject
    BoatTypeRepository boatTypeRepository;
    @Inject
    CrewMemberRepository crewMemberRepository;
    @Inject
    LocationRepository locationRepository;
    @Inject
    PersonRepository personRepository;
    @Inject
    RouteEntryRepository routeEntryRepository;
    @Inject
    TourRepository tourRepository;
    @Inject
    TourStateRepository tourStateRepository;

    public InitBean() {
    }

    void insertEnums() {
        BoatType boatType1 = new BoatType("ANDERE");
        BoatType boatType2 = new BoatType("ZWEIER");
        BoatType boatType3 = new BoatType("DREIER");
        BoatType boatType4 = new BoatType("VIERER");
        BoatType boatType5 = new BoatType("FÜNFER");
        BoatType boatType6 = new BoatType("ACHTER");

        BoatState boatState1 = new BoatState("BOOKED");
        BoatState boatState2 = new BoatState("DEFECT");
        BoatState boatState3 = new BoatState("NOT AVAILABLE");
        BoatState boatState4 = new BoatState("AVAILABLE");

        TourState tourState1 = new TourState("FINISHED");
        TourState tourState2 = new TourState("PLANNED");
        TourState tourState3 = new TourState("CANCELLED");

        boatTypeRepository.save(boatType1);
        boatTypeRepository.save(boatType2);
        boatTypeRepository.save(boatType3);
        boatTypeRepository.save(boatType4);
        boatTypeRepository.save(boatType5);
        boatTypeRepository.save(boatType6);

        boatStateRepository.save(boatState1);
        boatStateRepository.save(boatState2);
        boatStateRepository.save(boatState3);
        boatStateRepository.save(boatState4);

        tourStateRepository.save(tourState1);
        tourStateRepository.save(tourState2);
        tourStateRepository.save(tourState3);
    }



    void onStart(@Observes StartupEvent ev) {
        insertEnums();

    }
}

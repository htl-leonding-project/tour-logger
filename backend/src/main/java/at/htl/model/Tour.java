package at.htl.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TOUR")
public class Tour {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "T_ID")
    Long id;
    @Column(name = "T_DESTINATION")
    String destination;
    @Column(name = "T_DISTANCE")
    int distance;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Boat boat;
    @ElementCollection
    List<String> drivers;



    //region constructors
    public Tour() {
    }

    public Tour(ArrayList<String> drivers, String destination, int distance, Boat boat) {
        this.drivers = drivers;
        this.destination = destination;
        this.distance = distance;
        this.boat = boat;
    }

    public Tour(Long id, ArrayList<String> drivers, String destination, int distance, Boat boat) {
        this.id = id;
        this.drivers = drivers;
        this.destination = destination;
        this.distance = distance;
        this.boat = boat;
    }

    //endregion

    //region getset
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    //endregion


    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", drivers=" + drivers +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", boat=" + boat +
                '}';
    }
}

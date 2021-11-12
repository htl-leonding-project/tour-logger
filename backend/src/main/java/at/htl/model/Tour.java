package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
@Table(name = "TOUR")
public class Tour {


    @Id @Column(name = "T_ID") @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "T_FIRST_NAME")
    String firstName;
    @Column(name = "T_LAST_NAME")
    String lastName;
    @Column(name = "T_BOAT")
    String boat;
    @Column(name = "T_DESTINATION")
    String destination;
    @Column(name = "T_DISTANCE")
    int distance;

    //region constructors
    public Tour() {
    }

    public Tour(Long id, String firstName, String lastName, String boat, String destination, int distance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.boat = boat;
        this.destination = destination;
        this.distance = distance;
    }
    //endregion

    //region getset
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBoat() {
        return boat;
    }

    public void setBoat(String boat) {
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", boat='" + boat + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
    }
}

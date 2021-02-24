package java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "ROUTE_ENTRY")
public class RouteEntry {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RE_ID")
    Long id;

    @ManyToOne
    @JoinColumn(name = "RE_L")
    Location location;

    @ManyToOne
    @JoinColumn(name = "RE_T")
    Tour tour;

    public RouteEntry() {
    }

    public RouteEntry(Location location, Tour tour) {
        this.location = location;
        this.tour = tour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "RouteEntry{" +
                "id=" + id +
                ", location=" + location +
                ", tour=" + tour +
                '}';
    }
}

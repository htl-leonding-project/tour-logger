package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "TOUR")
public class Tour {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "T_ID")
    Long id;

    @Column(name = "T_DESC")
    String desc;

    @ManyToOne
    @JoinColumn(name = "T_TS")
    TourState tourState;

    @ManyToOne
    @JoinColumn(name = "T_B")
    Boat boat;

    @ManyToOne
    @JoinColumn(name = "T_RE")
    RouteEntry routeEntry;

    public Tour() {
    }

    public Tour(String desc, TourState tourState, Boat boat, RouteEntry routeEntry) {
        this.desc = desc;
        this.tourState = tourState;
        this.boat = boat;
        this.routeEntry = routeEntry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TourState getTourState() {
        return tourState;
    }

    public void setTourState(TourState tourState) {
        this.tourState = tourState;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public RouteEntry getRouteEntry() {
        return routeEntry;
    }

    public void setRouteEntry(RouteEntry routeEntry) {
        this.routeEntry = routeEntry;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", tourState=" + tourState +
                ", boat=" + boat +
                ", routeEntry=" + routeEntry +
                '}';
    }
}

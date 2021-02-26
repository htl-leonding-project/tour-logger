package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "BOAT_STATE")
public class BoatState {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BS_ID")
    Long id;

    @Column(name = "BS_STATE")
    String state;

    public BoatState() {
    }

    public BoatState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BoatState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}

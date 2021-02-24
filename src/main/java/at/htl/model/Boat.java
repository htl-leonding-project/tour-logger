package java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "BOAT")
public class Boat {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "B_ID")
    Long id;

    @Column(name = "B_NAME")
    String name;

    @ManyToOne
    @JoinColumn(name = "B_BT")
    BoatType boatType;

    @OneToOne
    @JoinColumn(name = "B_BS")
    BoatState boatState;

    public Boat() {
    }

    public Boat(String name, BoatType boatType) {
        this.name = name;
        this.boatType = boatType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boatType=" + boatType +
                '}';
    }
}

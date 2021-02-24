package java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "BOAT_TYPE")
public class BoatType {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BT_ID")
    Long id;

    @Column(name = "BT_TYPE")
    String type;

    public BoatType() {
    }

    public BoatType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BoatType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}

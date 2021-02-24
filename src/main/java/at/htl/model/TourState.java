package java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "TOUR_STATE")
public class TourState {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TS_ID")
    Long id;

    @Column(name = "TS_DESC")
    String desc;

    public TourState() {
    }

    public TourState(String desc) {
        this.desc = desc;
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

    @Override
    public String toString() {
        return "TourState{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}

package java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "L_ID")
    Long id;

    @Column(name = "L_DESC")
    String desc;

    @Column(name = "L_LONG")
    float longitude;

    @Column(name = "L_LAT")
    float latitude;

    public Location() {
    }

    public Location(String desc, float longitude, float latitude) {
        this.desc = desc;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}

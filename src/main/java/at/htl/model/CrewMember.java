package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "CREW_MEMBER")
@NamedQuery(name = "CrewMember.findAll", query = "select cm from CrewMember cm")
public class CrewMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_ID")
    Long id;

    @Column(name = "CM_DESC")
    String desc;

    @ManyToOne
    @JoinColumn(name = "CM_T")
    Tour tour;

    @ManyToOne
    @JoinColumn(name = "CM_P")
    Person person;

    public CrewMember() {
    }

    public CrewMember(String desc, Tour tour, Person person) {
        this.desc = desc;
        this.tour = tour;
        this.person = person;
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

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", tour=" + tour +
                ", person=" + person +
                '}';
    }
}

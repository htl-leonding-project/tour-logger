package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "CREW_MEMBER")
@NamedQuery(name = "CrewMember.findAll", query = "select cm from CrewMember cm")
public class CrewMember {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CM_ID")
    Long id;

    @Column(name = "CM_ROLE")
    String role;

    @ManyToOne
    @JoinColumn(name = "CM_TOUR")
    Tour tour;

    @ManyToOne
    @JoinColumn(name = "CM_PERSON")
    Person person;

    public CrewMember() {
    }

    public CrewMember(String role, Tour tour, Person person) {
        this.role = role;
        this.tour = tour;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
                ", role='" + role + '\'' +
                ", tour=" + tour +
                ", person=" + person +
                '}';
    }
}

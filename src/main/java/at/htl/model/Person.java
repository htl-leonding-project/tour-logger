package java.at.htl.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    Long id;

    @Column(name = "P_NAME")
    String name;

    @Column(name = "P_BDAY")
    LocalDate birthday;

    @Column(name = "P_STATE")
    String state;

    public Person() {
    }

    public Person(String name, LocalDate birthday, String state) {
        this.name = name;
        this.birthday = birthday;
        this.state = state;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", state='" + state + '\'' +
                '}';
    }
}

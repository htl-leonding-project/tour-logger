package at.htl.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PERSON")
@NamedQuery(name = "Person.findAll", query = "select p from Person p")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    Long id;

    @Column(name = "P_FIRSTNAME")
    String firstName;

    @Column(name = "P_LASTNAME")
    String lastName;

    @Column(name = "P_BDAY")
    LocalDate birthday;


    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

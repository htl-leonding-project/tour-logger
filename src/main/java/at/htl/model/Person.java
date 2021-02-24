package main.java.at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "P_ID")
    Long id;
    @Column(name = "P_NAME")
    String name;

    //TODO localDate
    @Column(name = "P_BDAY")


}

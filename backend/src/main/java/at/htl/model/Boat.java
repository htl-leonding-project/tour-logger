package at.htl.model;

import javax.persistence.*;

@Entity
@Table(name = "BOAT")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "B_ID")
    Long id;
    @Column(name = "B_NAME")
    String name;
    @Column(name = "B_SEATS")
    int nrOfSeats;
    @Column(name = "B_TYPE_SEATS")
    String typeSeats;

    public Boat() {
    }

    public Boat(String name, int nrOfSeats) {
        this.name = name;
        this.nrOfSeats = nrOfSeats;
    }

    public Boat(String name, String typeSeats) {
        this.name = name;
        this.typeSeats = typeSeats;

        switch (this.typeSeats) {
            case "Einer" -> {
                this.nrOfSeats = 1;
                System.out.println(this.name + ": " + this.nrOfSeats);
            }
            case "Zweier", "Doppelzweier" -> {
                this.nrOfSeats = 2;
                System.out.println(this.name + ": " + this.nrOfSeats);
            }
            case "Vierer", "Doppelvierer" -> {
                this.nrOfSeats = 4;
                System.out.println(this.name + ": " + this.nrOfSeats);
            }
            case "Achter", "Doppelachter" -> {
                this.nrOfSeats = 8;
                System.out.println(this.name + ": " + this.nrOfSeats);
            }
            default -> this.nrOfSeats = 1;
        }
    }

    public Boat(String name, int nrOfSeats, String typeSeats) {
        this.name = name;
        this.nrOfSeats = nrOfSeats;
        this.typeSeats = typeSeats;
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

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public String getTypeSeats() {
        return typeSeats;
    }

    public void setTypeSeats(String typeSeats) {
        this.typeSeats = typeSeats;
    }
}

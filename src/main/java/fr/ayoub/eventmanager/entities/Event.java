package fr.ayoub.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String animator;
    private String picture;
    @ManyToOne
    private Theme theme;

    public String toString() {
        return null;
    }

    @ManyToMany
    @JoinTable(name ="Event_Sponsor_Associations",
        joinColumns = @JoinColumn( name ="idEvent"),
        inverseJoinColumns = @JoinColumn( name = "idSponsor"))
    private List<Sponsor> Sponsors = new ArrayList<>();
}

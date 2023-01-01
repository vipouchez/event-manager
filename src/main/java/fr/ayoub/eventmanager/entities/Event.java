package fr.ayoub.eventmanager.entities;

import lombok.Data;

import javax.persistence.*;

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

    public String toString(){
        return null;
    }

}

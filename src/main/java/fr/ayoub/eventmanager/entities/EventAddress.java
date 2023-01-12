package fr.ayoub.eventmanager.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="address")
@Data
public class EventAddress {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String city;
    private String district;
    private String streetName;
    private long streetCode;


@OneToOne(mappedBy= "address")
    private Event event;

}

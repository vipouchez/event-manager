package event.entities;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Data

@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String animator;
    private String picture;
    @ManyToOne
    private  Theme theme;

    public String toString(){
        return null;
    }

}

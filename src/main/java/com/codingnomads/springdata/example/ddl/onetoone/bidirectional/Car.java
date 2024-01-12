/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.onetoone.bidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(name = "horsepower")
    private int horsepower;

    // note that this annotation and field is new
    @OneToOne(
            // used to indicate that this is the child side of a relationship and refer the JPA
            // to the field in the Driver class that defines the relationship
            mappedBy = "car")
    private Driver driver;
}

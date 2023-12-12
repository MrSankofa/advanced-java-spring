/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

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
    private String horsepower;
}

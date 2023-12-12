/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.ddl.onetoone.unidirectional;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@NoArgsConstructor
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    @OneToOne
    private Car car;
}

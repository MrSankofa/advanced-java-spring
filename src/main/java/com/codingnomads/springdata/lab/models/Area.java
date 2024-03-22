/* CodingNomads (C)2024 */
package com.codingnomads.springdata.lab.models;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "areas")
@Builder
@ToString
public class Area implements Serializable {

    private static final long serialVersionUID = 153236560504273881L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;
}

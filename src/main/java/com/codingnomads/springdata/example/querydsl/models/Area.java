/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.querydsl.models;

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

    private String name;
    private String code;
}

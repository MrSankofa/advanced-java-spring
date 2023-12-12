package com.codingnomads.springdata.example.dml.usingqueryannotation.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "soil_types")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SoilType {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private double ph;

    @Column(nullable = false)
    private boolean dry;

}

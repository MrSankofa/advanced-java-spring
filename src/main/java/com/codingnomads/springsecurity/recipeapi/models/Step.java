package com.codingnomads.springsecurity.recipeapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Step {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private int stepNumber;

    @Column(nullable = false)
    private String description;

}

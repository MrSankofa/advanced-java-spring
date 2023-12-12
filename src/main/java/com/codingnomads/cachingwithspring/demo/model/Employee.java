/* CodingNomads (C)2023 */
package com.codingnomads.cachingwithspring.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 6527855645691638321L;

    @Id
    @GeneratedValue
    private int id;

    private String name;
}

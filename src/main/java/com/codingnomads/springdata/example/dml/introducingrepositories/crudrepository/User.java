/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.introducingrepositories.crudrepository;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Integer age;
}

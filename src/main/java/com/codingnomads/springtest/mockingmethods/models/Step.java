/* CodingNomads (C)2023 */
package com.codingnomads.springtest.mockingmethods.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Step {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int stepNumber;

    @Column(nullable = false)
    private String description;
}

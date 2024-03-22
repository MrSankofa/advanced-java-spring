/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.introducingrepositories.jparepository;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SoftDrink {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int rating;

    @PrePersist
    @PreUpdate
    public void confirmRating() {
        if (rating < 0 || rating > 10) {
            throw new IllegalStateException("Rating must be between 0 and 10!");
        }
    }
}

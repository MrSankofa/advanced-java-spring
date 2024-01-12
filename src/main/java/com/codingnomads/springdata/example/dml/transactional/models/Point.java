/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.transactional.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "points")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Point {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int x;

    @Column(nullable = false)
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

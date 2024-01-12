/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeePreference {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private boolean sugar;

    @Column(nullable = false)
    private boolean iced;

    @Column(nullable = false)
    private Size size;

    @Column(nullable = false)
    private int intensity;

    public void setIntensity(int intensity) {

        if (intensity < 0 || intensity > 10) {
            throw new IllegalStateException("Intensity must be between 0 and 10");
        }

        this.intensity = intensity;
    }

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
}

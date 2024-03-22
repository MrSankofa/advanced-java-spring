/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.recipeapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_meta")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserMeta {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;
}

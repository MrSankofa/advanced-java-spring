/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.jpa.domain;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tags")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tags")
    @Builder.Default
    private Set<Post> posts = new HashSet<>();
}

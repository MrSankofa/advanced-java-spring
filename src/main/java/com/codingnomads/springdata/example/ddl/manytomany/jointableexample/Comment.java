/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.ddl.manytomany.jointableexample;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;
}

/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.manytoone.bidirectional;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, updatable = false)
    private String username;

    @Column(nullable = false)
    private String content;

    // this annotation references the configuration on the post field in the Comment class
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;
}

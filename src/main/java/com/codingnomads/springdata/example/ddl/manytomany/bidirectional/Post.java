/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.ddl.manytomany.bidirectional;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id", nullable = false)
    private Set<Comment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Location> locations;
}

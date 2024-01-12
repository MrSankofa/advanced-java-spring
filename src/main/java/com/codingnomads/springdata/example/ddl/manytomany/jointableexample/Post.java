/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.ddl.manytomany.jointableexample;

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
    @JoinTable(
            // change join table name
            name = "post_location_join_table",
            // specify a column named location_latitude referencing the latitude column in the locations table
            inverseJoinColumns = @JoinColumn(name = "location_latitude", referencedColumnName = "latitude"))
    private Set<Location> locations;
}

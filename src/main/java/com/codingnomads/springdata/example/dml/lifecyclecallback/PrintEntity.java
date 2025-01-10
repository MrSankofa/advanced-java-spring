/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    String make;

    // so you can have functions that do something and add the annotation to hook into the lifecycle to invoke this method at that point?

    // write your methods here
    @PostLoad
    public void postLoad() {
        // code to execute after the entity is loaded
        System.out.println("Post Load just in case you want to do something");

    }
    @PrePersist
    public void prePersist() {
        // code to execute before persisting
        System.out.println("Pre persist just in case you want to do something");
    }

    @PreUpdate
    public void preUpdate() {
        // code to execute before updating
        System.out.println("Pre update just in case you want to do something");
    }

    @PreRemove
    public void preRemove() {
        // code to execute before removing
        System.out.println("Pre delete just in case you want to do something");
    }


}

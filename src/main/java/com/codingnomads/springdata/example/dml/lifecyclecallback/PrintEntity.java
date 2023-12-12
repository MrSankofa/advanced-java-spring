/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    // write your methods here

}

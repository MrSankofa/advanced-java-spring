/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.codewarriorexample;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String emailAddress;
}

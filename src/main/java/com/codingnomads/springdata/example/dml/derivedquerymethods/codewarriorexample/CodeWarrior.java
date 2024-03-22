/* CodingNomads (C)2024 */
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
public class CodeWarrior {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "email_address_id")
    private EmailAddress emailAddress;

    private Integer age;
    private Boolean active;
}

package com.codingnomads.springdata.example.dml.commonproblems.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "contact_cards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "user")
public class ContactCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String emailAddress;

    private String websiteUrl;

    private String phoneNumber;

    @OneToOne(mappedBy = "contactCard")
    private User user;

}

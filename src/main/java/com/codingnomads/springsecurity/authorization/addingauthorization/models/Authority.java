/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.addingauthorization.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthorityEnum authority;

    public String getAuthority() {
        return authority.name();
    }
}

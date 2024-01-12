/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.requestbody.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Boolean completed;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}

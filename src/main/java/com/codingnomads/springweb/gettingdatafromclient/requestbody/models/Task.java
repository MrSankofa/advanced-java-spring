package com.codingnomads.springweb.gettingdatafromclient.requestbody.models;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

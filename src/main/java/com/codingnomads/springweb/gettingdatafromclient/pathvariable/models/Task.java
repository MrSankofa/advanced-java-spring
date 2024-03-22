/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.pathvariable.models;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Task {
    private Long id;
    private String name;
    private Boolean completed;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}

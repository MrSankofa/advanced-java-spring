/* CodingNomads (C)2023 */
package com.codingnomads.springweb.gettingdatafromclient.requestparam.models;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Task {
    private Long id;
    private String name;

    @Builder.Default
    private Boolean completed = false;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}

/* CodingNomads (C)2025 */
package com.codingnomads.springweb.resttemplate.GET.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class ExcuserTemplate {
    private int id;
    private String excuse;
    private String category;
}

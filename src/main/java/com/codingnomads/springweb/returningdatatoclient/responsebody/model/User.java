/* CodingNomads (C)2023 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {

    private int id;

    private String name;

    private String email;
}

/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.aopproxy.models;

import lombok.Data;

@Data
public class PersonImpl implements Person {

    private String firstName;
    private String lastName;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}

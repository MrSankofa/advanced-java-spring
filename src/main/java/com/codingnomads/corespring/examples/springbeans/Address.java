/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private Integer streetNumber;

    public Address(String street, Integer streetNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
    }
}

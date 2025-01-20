/* CodingNomads (C)2025 */
package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employer {
    private String name;
    private int size;
    private int revenue;

    public Employer(String name, int size, int revenue) {
        this.name = name;
        this.size = size;
        this.revenue = revenue;
    }
}

/* CodingNomads (C)2023 */
package com.codingnomads.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;

    public SpringDeveloper(Address address) {
        this.address = address;
    }
}

/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.profileannotation;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class SpringDeveloper {
    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }
}

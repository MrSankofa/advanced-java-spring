/* CodingNomads (C)2023 */
package com.codingnomads.corespring.examples.dependsonannotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringDeveloper {
    @Autowired
    private JDK jdk;

    public SpringDeveloper() {
        System.out.println("SpringDeveloper is ready.");
    }
}

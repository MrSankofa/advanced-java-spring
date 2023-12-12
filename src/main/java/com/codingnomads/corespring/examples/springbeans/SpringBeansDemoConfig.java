/* CodingNomads (C)2023 */
package com.codingnomads.corespring.examples.springbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SpringDeveloper.class)
public class SpringBeansDemoConfig {
    @Bean
    public Address address() {
        return new Address("Main Street", 1500);
    }
}

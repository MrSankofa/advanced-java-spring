/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanscopes.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PrototypeDemoConfig {
    @Bean
    @Scope(value = "prototype")
    public SpringBean springBean() {
        return new SpringBean();
    }
}

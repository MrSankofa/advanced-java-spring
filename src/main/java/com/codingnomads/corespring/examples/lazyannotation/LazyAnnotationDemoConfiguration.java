/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.lazyannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Lazy
@ComponentScan(basePackages = "com.codingnomads.corespring.examples.lazyannotation")
public class LazyAnnotationDemoConfiguration {
    @Bean
    public LazyBean lazyBean() {
        return new LazyBean();
    }
}

/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.scopeannotaion;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeAnnotationDemoConfig {
    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}

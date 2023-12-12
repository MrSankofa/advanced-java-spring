/* CodingNomads (C)2023 */
package com.codingnomads.ioc.examples.dependencylookup;

public interface GreetingRenderer {
    void render();

    void setGreetingProvider(GreetingProvider greetingProvider);

    GreetingProvider getGreetingProvider();
}

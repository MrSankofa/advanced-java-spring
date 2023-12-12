/* CodingNomads (C)2023 */
package com.codingnomads.ioc.examples.dependencylookup;

public class CodingNomadsGreetingProvider implements GreetingProvider {
    @Override
    public String getGreeting() {
        return "Hello CodingNomads!";
    }
}

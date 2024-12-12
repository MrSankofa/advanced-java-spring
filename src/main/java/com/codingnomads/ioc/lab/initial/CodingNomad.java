/* CodingNomads (C)2024 */
package com.codingnomads.ioc.lab.initial;

import java.text.MessageFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/*
* The @Component annotation designates this class as a "component",
* marking it as a candidate for Spring's component scanning.
* When a class is annotated with @Component, it becomes eligible for Spring to automatically detect
*  and register it as a bean in the ApplicationContext, enabling dependency injection and lifecycle management.
*
*
* @RequiredArgsConstructor is a Lombok annotation that generates a constructor for all final fields and
* fields with constraints such as @NonNull. In your CodingNomad class, @RequiredArgsConstructor will generate
* the following constructor automatically due to all three fields (jdk, ide, framework) being declared as final:

 * */
@Component
@RequiredArgsConstructor // Solves this problem - Variable 'framework' might not have been initialized, where the
// constructor is not setting these properties
public class CodingNomad {
    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;

    public String createAwesomeSoftware() {
        return MessageFormat.format(
                "This coding nomad is creating awesome software using, "
                        + "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5})",
                ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion());
    }
}

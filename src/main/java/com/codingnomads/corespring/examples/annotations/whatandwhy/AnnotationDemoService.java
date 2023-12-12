/* CodingNomads (C)2023 */
package com.codingnomads.corespring.examples.annotations.whatandwhy;

public class AnnotationDemoService implements LegacyInfoProvider {

    @ModernInfo
    @Override
    public String info() {
        return "legacy api fetching information";
    }
}

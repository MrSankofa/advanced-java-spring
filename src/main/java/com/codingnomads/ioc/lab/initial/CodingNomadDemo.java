/* CodingNomads (C)2024 */
package com.codingnomads.ioc.lab.initial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CodingNomadDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CodingNomadConfiguration.class);
        CodingNomad codingNomad = context.getBean(CodingNomad.class);
        System.out.println(codingNomad.createAwesomeSoftware());
    }
}

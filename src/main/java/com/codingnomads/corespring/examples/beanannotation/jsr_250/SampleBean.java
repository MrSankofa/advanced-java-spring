/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.beanannotation.jsr_250;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }

    @PostConstruct
    public void populate() {
        System.out.println("populate method called");
    }

    @PreDestroy
    public void backupDeleted() {
        System.out.println("Saved deleted just in case you didn't mean to :) ");
    }
}

/* CodingNomads (C)2024 */
package com.codingnomads.springweb.gettingdatafromclient.handlingmultipartdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MultiPartFileDemo {
    public static void main(String[] args) {
        SpringApplication.run(MultiPartFileDemo.class);
    }
}

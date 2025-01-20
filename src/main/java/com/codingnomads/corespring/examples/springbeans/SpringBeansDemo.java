/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.springbeans;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringBeansDemo {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringBeansDemoConfig.class);
        SpringDeveloper springDeveloper = ctx.getBean(SpringDeveloper.class);
        System.out.println("Spring Developer Address: "
                + springDeveloper.getAddress().getStreetNumber() + " "
                + springDeveloper.getAddress().getStreet() + " "
                + "Spring Developer Employer: " + springDeveloper.getEmployer().getName() + " "
                + "Spring Developer Size: " + springDeveloper.getEmployer().getSize() + " "
                + "Spring Developer Revenue: " + springDeveloper.getEmployer().getRevenue());
    }
}

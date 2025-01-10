/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.lifecyclecallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LifecycleCallbackDemo {

    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Autowired
    PrintEntityRepository printEntityRepository;
    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here

            PrintEntity printEntity = new PrintEntity(); // No Hibernate
            System.out.println("Creating new PrintEntity");
            printEntity.setMake("Toyota"); // No Hibernate
            System.out.println("Updating PrintEntity make to toyota");


            printEntityRepository.save(printEntity); // Hibernate query - triggers pre persist
            System.out.println("Updating change to PrintEntity");


            printEntity.setMake("Ford"); // No Hibernate
            System.out.println("Updating PrintEntity make to Ford");
            printEntityRepository.save(printEntity); // Hiberate query find record with id and make of printEntity and update respectively, triggered post Load, pre update respectively
            System.out.println("Updating change to PrintEntity from ford");
//            printEntity.setMake("BMW");
            printEntityRepository.findAll(); // Hibernate query select all with id, make, triggers post load
            System.out.println("Getting all PrintEntity");

            printEntityRepository.delete(printEntity);// hiberate query find by id and make then delete, triggers post load and pre delete
            System.out.println("Deleting the PrintEntity" + printEntity);

        };
    }
}

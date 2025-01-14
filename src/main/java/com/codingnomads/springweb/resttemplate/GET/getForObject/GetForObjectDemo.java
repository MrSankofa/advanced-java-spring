/* CodingNomads (C)2024 */
package com.codingnomads.springweb.resttemplate.GET.getForObject;

import com.codingnomads.springweb.resttemplate.GET.models.ExcuserTemplate;
import com.codingnomads.springweb.resttemplate.GET.models.QuoteTemplate;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    // so the rest template allows you to create a type T in which you can make a request to a URL and get that data mapped to the java type T you created
    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println("random quote");
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here

            ExcuserTemplate[] randomExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/family/", ExcuserTemplate[].class);

            System.out.println("random excuse");
            System.out.println(Arrays.toString(randomExcuse));

            //        CodingNomadsTasksApiResponse response =
            //                restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
            //                        CodingNomadsTasksApiResponse.class);
            //
            //        System.out.println(response.toString());

        };
    }
}

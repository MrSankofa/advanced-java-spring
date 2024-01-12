/* CodingNomads (C)2024 */
package com.codingnomads.aspectorientedprogramming.aopproxy.services;

import com.codingnomads.aspectorientedprogramming.aopproxy.models.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public String getPersonFullName(Person person) {
        return person.getFullName();
    }
}

/* CodingNomads (C)2023 */
package com.codingnomads.springtest.usingtestresttemplate.services;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import com.codingnomads.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }
}

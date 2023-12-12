package com.codingnomads.springtest.usingtestresttemplate.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;

public interface CoffeePreferenceRepo extends JpaRepository<CoffeePreference, Long> {
}

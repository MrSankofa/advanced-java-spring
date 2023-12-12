/* CodingNomads (C)2023 */
package com.codingnomads.springtest.usingtestresttemplate.repos;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeePreferenceRepo extends JpaRepository<CoffeePreference, Long> {}

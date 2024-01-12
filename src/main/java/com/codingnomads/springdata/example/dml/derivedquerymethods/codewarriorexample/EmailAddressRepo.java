/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.codewarriorexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailAddressRepo extends JpaRepository<EmailAddress, Long> {

    EmailAddress findByEmailAddress(String emailAddress);
}

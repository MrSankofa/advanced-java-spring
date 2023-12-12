/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.dml.derivedquerymethods.codewarriorexample;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeWarriorRepo extends JpaRepository<CodeWarrior, Long> {
    CodeWarrior findByEmailAddressAndLastName(EmailAddress emailAddress, String lastName);

    List<CodeWarrior> findByLastNameIs(String lastName);

    List<CodeWarrior> findByLastNameIsNot(String lastName);

    List<CodeWarrior> findByLastNameIsNull();

    List<CodeWarrior> findByLastNameIsNotNull();

    List<CodeWarrior> findByActiveIsTrue();

    List<CodeWarrior> getByLastName(String lastName);

    List<CodeWarrior> queryByLastName(String lastName);

    List<CodeWarrior> readByLastName(String lastName);

    Integer countByLastName(String lastName);

    List<CodeWarrior> findByLastNameStartingWith(String prefix);

    List<CodeWarrior> findByLastNameEndingWith(String prefix);

    List<CodeWarrior> findByLastNameContaining(String infix);

    List<CodeWarrior> findByAgeLessThan(Integer age);

    List<CodeWarrior> findByAgeLessThanEqual(Integer age);

    List<CodeWarrior> findByAgeGreaterThan(Integer age);

    List<CodeWarrior> findByAgeGreaterThanEqual(Integer age);

    List<CodeWarrior> findByLastNameContainingAndAgeGreaterThanEqual(String lastName, Integer age);

    List<CodeWarrior> findTop2ByLastName(String lastName);

    List<CodeWarrior> findByLastNameIgnoreCase(String lastName);

    // Enabling ignoring case for all suitable properties
    List<CodeWarrior> findByLastNameAndFirstNameAllIgnoreCase(String lastName, String firstName);

    // Enabling static ORDER BY for a query
    List<CodeWarrior> findByLastNameOrderByFirstNameAsc(String lastName);

    List<CodeWarrior> findByLastNameOrderByFirstNameDesc(String lastName);

    CodeWarrior findByEmailAddress_EmailAddress(String emailAddress);
}

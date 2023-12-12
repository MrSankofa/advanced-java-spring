/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.jpa.repositories;

import com.codingnomads.springdata.example.jpa.domain.CodeWarrior;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeWarriorRepository extends JpaRepository<CodeWarrior, Long> {}

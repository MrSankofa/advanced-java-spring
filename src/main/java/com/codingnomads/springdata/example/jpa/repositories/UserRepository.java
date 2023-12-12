/* CodingNomads (C)2023 */
package com.codingnomads.springdata.example.jpa.repositories;

import com.codingnomads.springdata.example.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}

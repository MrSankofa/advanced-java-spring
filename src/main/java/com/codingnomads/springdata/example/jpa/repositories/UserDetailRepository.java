/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.jpa.repositories;

import com.codingnomads.springdata.example.jpa.domain.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {}

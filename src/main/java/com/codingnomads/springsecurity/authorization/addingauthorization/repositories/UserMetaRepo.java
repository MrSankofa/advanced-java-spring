/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.addingauthorization.repositories;

import com.codingnomads.springsecurity.authorization.addingauthorization.models.UserMeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetaRepo extends JpaRepository<UserMeta, Long> {}

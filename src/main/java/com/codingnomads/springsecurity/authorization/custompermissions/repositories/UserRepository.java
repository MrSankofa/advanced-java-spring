/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.custompermissions.repositories;

import com.codingnomads.springsecurity.authorization.custompermissions.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    void deleteByEmail(String email);
}

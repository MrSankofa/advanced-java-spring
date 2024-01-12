/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.custompermissions.repositories;

import com.codingnomads.springsecurity.authorization.custompermissions.models.MyGrantedAuthority;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<MyGrantedAuthority, Long> {

    List<MyGrantedAuthority> findAllByObjectId(Long id);
}

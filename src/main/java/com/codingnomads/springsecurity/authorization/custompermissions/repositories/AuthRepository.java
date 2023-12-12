package com.codingnomads.springsecurity.authorization.custompermissions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springsecurity.authorization.custompermissions.models.MyGrantedAuthority;

import java.util.List;

public interface AuthRepository extends JpaRepository<MyGrantedAuthority, Long> {

    List<MyGrantedAuthority> findAllByObjectId(Long id);
}

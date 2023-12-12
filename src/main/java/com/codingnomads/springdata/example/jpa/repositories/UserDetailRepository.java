package com.codingnomads.springdata.example.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingnomads.springdata.example.jpa.domain.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}

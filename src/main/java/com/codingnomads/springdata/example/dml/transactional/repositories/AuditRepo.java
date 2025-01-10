package com.codingnomads.springdata.example.dml.transactional.repositories;

import com.codingnomads.springdata.example.dml.transactional.models.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepo extends JpaRepository<AuditLog, Long> {
}

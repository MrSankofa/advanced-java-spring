package com.codingnomads.springdata.example.dml.transactional.services;

import com.codingnomads.springdata.example.dml.transactional.models.AuditLog;
import com.codingnomads.springdata.example.dml.transactional.repositories.AuditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// TODO: what does the Service, Repository annotations do?
@Service
public class AuditService {

  @Autowired
  AuditRepo auditRepo;

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void logAudit(Long pointId, String message) {
    // Create a new AuditLog entry
    AuditLog auditLog = new AuditLog();
    auditLog.setPointId(pointId);
    auditLog.setMessage(message);
    auditRepo.save(auditLog);

    System.out.println("Audit logged: " + message);
  }


}

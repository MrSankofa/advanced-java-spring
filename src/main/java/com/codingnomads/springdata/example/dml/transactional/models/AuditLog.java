package com.codingnomads.springdata.example.dml.transactional.models;

import jakarta.persistence.*;

@Entity
public class AuditLog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long pointId;

  @Column(nullable = false)
  private String message;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPointId() {
    return pointId;
  }

  public void setPointId(Long pointId) {
    this.pointId = pointId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
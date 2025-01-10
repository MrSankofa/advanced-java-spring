package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Cars {
  public String name;
  public String make;
  public String model;
  public int year;
  @Id
  private Long id;

  public Cars() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}

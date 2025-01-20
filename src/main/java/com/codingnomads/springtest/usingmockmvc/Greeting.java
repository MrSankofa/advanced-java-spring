package com.codingnomads.springtest.usingmockmvc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {
  private String greeting;

  public Greeting(String greeting) {
    this.greeting = greeting;
  }
}

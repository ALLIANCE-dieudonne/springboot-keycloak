package com.alliance.keycloak;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

  @GetMapping
  public String hello(){
    return "Hello from spring boot and keyclaok";
  }

  @GetMapping("/hello2")
  public String hello2(){
    return "authorized hello";
  }

}

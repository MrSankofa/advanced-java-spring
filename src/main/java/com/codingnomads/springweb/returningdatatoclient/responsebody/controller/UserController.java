/* CodingNomads (C)2023 */
package com.codingnomads.springweb.returningdatatoclient.responsebody.controller;

import com.codingnomads.springweb.returningdatatoclient.responsebody.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.co")
            .build();

    // using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    // using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // returning a POJO without ResponseBody or using a ResponseEntity - error expected
    @GetMapping("/user")
    public User user() {
        return user;
    }
}

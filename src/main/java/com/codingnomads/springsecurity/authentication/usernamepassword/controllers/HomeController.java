/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authentication.usernamepassword.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "basicauthentication/home";
    }
}

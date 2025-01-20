/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingmockmvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }


    // Serve a "Contact Us" page
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // Display a random motivational quote
    @GetMapping("/quote")
    @ResponseBody
    public String randomQuote() {
        String[] quotes = {
            "Believe in yourself!",
            "Every day is a second chance.",
            "Dream big, work hard."
        };
        int index = (int) (Math.random() * quotes.length);
        return quotes[index];
    }

    // Redirect to the homepage
    @GetMapping("/redirect-home")
    public String redirectToHome() {
        return "redirect:/";
    }
}

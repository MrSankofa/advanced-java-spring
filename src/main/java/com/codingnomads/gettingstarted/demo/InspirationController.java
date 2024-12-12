/* CodingNomads (C)2024 */
package com.codingnomads.gettingstarted.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InspirationController {

    @Autowired
    InspirationService inspirationService;

    @GetMapping("/inspiration")
    public String inspiration(Model model) {

        model.addAttribute("quote", inspirationService.getRandomQuote());

        return "getting_started/inspiration";
    }
}

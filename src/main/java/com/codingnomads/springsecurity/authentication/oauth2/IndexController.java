/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authentication.oauth2;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getIndexPage(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "oauth2/index";
    }

    @GetMapping("/protected")
    public String getProtectedPage(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "oauth2/index";
    }
}

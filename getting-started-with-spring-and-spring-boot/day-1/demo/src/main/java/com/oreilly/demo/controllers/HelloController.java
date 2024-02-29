package com.oreilly.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// MVC - Model / View / Controller
// Model - Data (here it will be a way to carry data from one place to another)
// View - What the user sees
// Controller - Receives the HTTP requests and returns HTTP responses or forwards to a view

@Controller
public class HelloController {

    @GetMapping("/hello") // http://localhost:8080/hello?name=Dolly - Tomcat default port
    public String sayHello(
            // setting 'defaultValue' implicitly sets 'required' to false
            @RequestParam(defaultValue = "World") String name, Model model) {
        model.addAttribute("user", name);
        return "welcome"; // src/main/resources/templates/welcome.html
    }

}

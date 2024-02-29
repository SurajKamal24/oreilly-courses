package com.oreilly.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class HelloRestController {

    @GetMapping
    public Greeting greet(@RequestParam(defaultValue = "World") String name) {
        return new Greeting("Hello, %s!".formatted(name));
    }

    @PostMapping("{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Greeting greetPost(@PathVariable String name) {
        return new Greeting("Hello, %s!".formatted(name));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Greeting> greetPostBody(@RequestBody Greeting greeting) {
        Greeting responseGreeting = new Greeting("Hello, %s!".formatted(greeting.message()));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseGreeting);
    }

}

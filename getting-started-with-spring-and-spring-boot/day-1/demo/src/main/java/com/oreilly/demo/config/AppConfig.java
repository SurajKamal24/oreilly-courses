package com.oreilly.demo.config;

import com.oreilly.demo.controllers.Greeting;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    public Greeting defaultGreeting() {
        return new Greeting("Hello, World!");
    }

    public Greeting germanGreeting() {
        return new Greeting("Hello, Welt!");
    }

}

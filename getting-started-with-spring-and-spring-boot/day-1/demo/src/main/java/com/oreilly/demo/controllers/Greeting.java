package com.oreilly.demo.controllers;

import org.springframework.stereotype.Component;

// Java records:
// - are immutable data holders
// - define a primary (canonical) constructore before the {}
// - define fields in constructor
// - define "getters" that match the field name, as in "message()"
// - autogenerate equals(), hashcode(), and toString()
@Component
// @Scope(""prototype)
public record Greeting(String message) {
}

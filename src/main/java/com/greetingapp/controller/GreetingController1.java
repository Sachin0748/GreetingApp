package com.greetingapp.controller;

import com.greetingapp.services.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController1 {

    private final GreetingService greetingService;

    // Constructor-based dependency injection
    public GreetingController1(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    static class Greeting {
        private final String message;

        public Greeting(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting(greetingService.getGreetingMessage());
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello, this is a POST request!");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello, this is a PUT request!");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello, this is a DELETE request!");
    }
}

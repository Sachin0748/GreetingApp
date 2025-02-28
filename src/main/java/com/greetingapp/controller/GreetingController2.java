package com.greetingapp.controller;

import com.greetingapp.services.GreetingService2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController2 {

    private final GreetingService2 greetingService;

    public GreetingController2(GreetingService2 greetingService) {
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
    public Greeting getGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return new Greeting(greetingService.getGreetingMessage(firstName, lastName));
    }
}

package com.cailliaud.chatbot.rsl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RSLController {

    @GetMapping("/hello-world")
    public String greeting() {
        return "hello-world";
    }
}

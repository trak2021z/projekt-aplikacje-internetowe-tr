package com.example.projektaplikacjeinternetowe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String test() {
        return "Hello there!";
    }
}

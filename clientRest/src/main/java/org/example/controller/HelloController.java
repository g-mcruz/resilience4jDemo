package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/{name}")
    public String hello(@PathVariable String name){
        return "Hello, "+ name;
    }

    @GetMapping("/sleep/{time}")
    public String sleep(@PathVariable Long time) throws InterruptedException {
        Thread.sleep(time);
        return "Acordou!!";
    }
}

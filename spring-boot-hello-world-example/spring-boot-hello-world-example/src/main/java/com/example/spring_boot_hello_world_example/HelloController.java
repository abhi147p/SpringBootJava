package com.example.spring_boot_hello_world_example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/home")
    public String helloworld(){
        return "Hello World!";
    }
}

package com.example.spring_boot_hello_world_example;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="mail")
public class ConfigProperties {

    private String from;
    private String to;
    private String defaultObject;

}

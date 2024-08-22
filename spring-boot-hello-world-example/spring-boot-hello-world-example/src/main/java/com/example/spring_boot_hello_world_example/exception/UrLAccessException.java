package com.example.spring_boot_hello_world_example.exception;

import lombok.Getter;

@Getter
public class UrLAccessException extends RuntimeException{

    private String url;

    public UrLAccessException(String url) {
        this(url, null);
    }

    public UrLAccessException(String url, Throwable cause) {
        super("Url "+url+"is not accessible", cause);
        this.url=url;
    }
}

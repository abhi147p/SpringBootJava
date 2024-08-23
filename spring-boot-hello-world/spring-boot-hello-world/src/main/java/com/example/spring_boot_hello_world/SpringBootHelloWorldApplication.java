package com.example.spring_boot_hello_world;

import com.example.spring_boot_hello_world.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	@Autowired
	private ConfigProperties configProperties;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" *** Show Arguments *** ");
		System.out.println("From: "+configProperties.getFrom());
		System.out.println("To: "+configProperties.getTo());
		System.out.println("default Object: "+configProperties.getDefaultObject());
		// For passing the args, we can do using the edit configurations.
	}
}

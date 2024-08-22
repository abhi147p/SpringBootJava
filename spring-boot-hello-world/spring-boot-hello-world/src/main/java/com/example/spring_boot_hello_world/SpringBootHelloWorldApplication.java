package com.example.spring_boot_hello_world;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootHelloWorldApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" *** Show Arguments *** ");
		Arrays.stream(args).forEach(System.out::println);
		// For passing the args, we can do using the edit configurations.
	}
}

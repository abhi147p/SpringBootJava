package com.example.spring_boot_hello_world;

import com.example.spring_boot_hello_world.exception.UrlAccessException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(" *** Show Arguments *** ");
//		Arrays.stream(args).forEach(System.out::println);
//		// For passing the args, we can do using the edit configurations.
//	}

	@EventListener(classes= ContextRefreshedEvent.class)
	public void listen(){
		throw new UrlAccessException("http://www.example.com");
	}
}

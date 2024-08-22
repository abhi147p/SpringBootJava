package com.example.spring_boot_hello_world_example;

import com.example.spring_boot_hello_world_example.exception.UrLAccessException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

// import java.util.Arrays;

@SpringBootApplication
// @EnableConfigurationProperties(ConfigProperties.class) // implements CommandLineRunner
public class SpringBootHelloWorldExampleApplication  {

//	@Autowired
//	ConfigProperties configProperties;

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);

	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(" *** Show Arguments ***");
//		Arrays.stream(args).forEach(System.out::println);
//	}

//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(" *** Mail Arguments ***");
//		// Arrays.stream(args.getSourceArgs()).forEach(System.out::println);
//		System.out.println("From : "+ configProperties.getFrom());
//		System.out.println("From : "+ configProperties.getTo());
//		System.out.println("From : "+ configProperties.getDefaultObject());
//	}
	@EventListener(classes= ContextRefreshedEvent.class)
	public void listen(){
		throw new UrLAccessException("http://www.example.com");
	}
}

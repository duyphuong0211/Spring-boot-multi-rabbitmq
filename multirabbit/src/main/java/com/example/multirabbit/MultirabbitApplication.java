package com.example.multirabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.example.multirabbit.*"})
@SpringBootApplication
public class MultirabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultirabbitApplication.class, args);
	}

}

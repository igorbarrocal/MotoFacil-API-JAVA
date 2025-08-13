package br.com.mottu.mottuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MottuapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MottuapiApplication.class, args);
	}
}

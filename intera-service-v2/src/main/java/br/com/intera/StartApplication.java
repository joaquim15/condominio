package br.com.intera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"br.com.intera"})
public class StartApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(StartApplication.class, args);
	}
}

package br.com.ifpe.rhcontrolmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class RhControlMailApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RhControlMailApplication.class, args);
	}

}

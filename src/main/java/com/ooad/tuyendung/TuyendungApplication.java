package com.ooad.tuyendung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class TuyendungApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuyendungApplication.class, args);
	}

}

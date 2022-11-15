package com.cursospringboot.localizacao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootApplication
public class LocalizacaoApplicationTests implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {


	}

	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplicationTests.class, args);
	}
}

package com.leonardoteixeiraa.carros_tabela_fipe;

import com.leonardoteixeiraa.carros_tabela_fipe.view.ApiFipeView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrosTabelaFipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarrosTabelaFipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApiFipeView view = new ApiFipeView();
		view.menu();
	}
}

package com.example.FacinabaoGacias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FacinabaoGaciasApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FacinabaoGaciasApplication.class, args);
		InventoryMenuService menuService = context.getBean(InventoryMenuService.class);
		menuService.displayMenu();

	}

}

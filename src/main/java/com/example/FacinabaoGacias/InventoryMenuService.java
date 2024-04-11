package com.example.FacinabaoGacias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Scanner;

@Service
public class InventoryMenuService {

    private final InventoryService inventoryService;
    private final Scanner scanner;

    @Autowired
    public InventoryMenuService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    inventoryService.getInventory().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    public void addItem() {
        System.out.println("Enter product name:");
        String name = scanner.nextLine();

        System.out.println("Enter product price:");
        BigDecimal price = scanner.nextBigDecimal();


        System.out.println("Enter product quantity:");
        Long quantity = scanner.nextLong();

        System.out.println("Enter product category:");
        Category category = Category.valueOf(scanner.next());

        System.out.println("Enter product status:");
        Status status = Status.valueOf(scanner.next());

        inventoryService.addItemToInventory(name, price, quantity, category, status);

    }
}

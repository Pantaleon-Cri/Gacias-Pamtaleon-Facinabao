package com.example.SimpleInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
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
            System.out.println("3. Display Product's Name");
            System.out.println("4. Exit");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please try again.");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    inventoryService.getInventory().forEach(System.out::println);
                    break;
                case 3:
                    displayProductByName();
                        break;

                case 4:
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

        Category category;
        do {
            System.out.print("Enter product category: ");
            String userInput = scanner.next();
            try {
                category = Category.valueOf(userInput);
            }catch (IllegalArgumentException e) {
                System.out.println("Invalid Category. Try Again");
                continue;
            }
            break;
        } while (true);



        inventoryService.addItemToInventory(name, price, quantity, category);

    }
    public void displayProductByName() {
        System.out.println("Enter the product's name: ");
        String name = scanner.nextLine();
        Product product = inventoryService.getProductByName(name);
        if(product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found");
        }
    }
}

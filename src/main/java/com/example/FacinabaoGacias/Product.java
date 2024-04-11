package com.example.FacinabaoGacias;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private Long quantity;
    private Category category;
    private Status status;

    public Product(String name, BigDecimal price, Long quantity, Category category, Status status) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.status = status;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" +price +
                ", quantity=" +quantity +
                ", category=" +category +
                ", status=" + status +
                '}';
    }
}



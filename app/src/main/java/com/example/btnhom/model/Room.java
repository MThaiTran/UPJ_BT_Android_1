package com.example.btnhom.model;

public class Room {
    private String id;
    private String name;
    private double price;
    private boolean isVacant;

    public Room(String id, String name, double price, boolean isVacant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isVacant = isVacant;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isVacant() { return isVacant; }
}
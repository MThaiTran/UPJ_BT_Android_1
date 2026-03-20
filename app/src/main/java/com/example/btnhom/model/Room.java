package com.example.btnhom.model;

import java.io.Serializable;

public class Room implements Serializable {
    private String roomId;
    private String roomName;
    private double rentPrice;
    private boolean isRented;
    private String tenantName;
    private String phoneNumber;
    private double area; // Diện tích
    private String notes; // Ghi chú

    public Room(String roomId, String roomName, double rentPrice, boolean isRented, String tenantName, String phoneNumber, double area, String notes) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.rentPrice = rentPrice;
        this.isRented = isRented;
        this.tenantName = tenantName;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.notes = notes;
    }

    // Secondary constructor for backward compatibility or simpler room creation
    public Room(String roomId, String roomName, double rentPrice, boolean isRented, String tenantName, String phoneNumber) {
        this(roomId, roomName, rentPrice, isRented, tenantName, phoneNumber, 0.0, "");
    }

    // Getters and Setters
    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getRoomName() { return roomName; }
    public void setRoomName(String roomName) { this.roomName = roomName; }

    public double getRentPrice() { return rentPrice; }
    public void setRentPrice(double rentPrice) { this.rentPrice = rentPrice; }

    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { isRented = rented; }

    public String getTenantName() { return tenantName; }
    public void setTenantName(String tenantName) { this.tenantName = tenantName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

package com.example.btnhom.model;

public class Room {
    private final String roomCode;
    private String roomName;
    private double rentPrice;
    private boolean rented;
    private String tenantName;
    private String tenantPhone;

    public Room(String roomCode, String roomName, double rentPrice, boolean rented, String tenantName, String tenantPhone) {
        this.roomCode = roomCode;
        this.roomName = roomName;
        this.rentPrice = rentPrice;
        this.rented = rented;
        this.tenantName = tenantName;
        this.tenantPhone = tenantPhone;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }
}


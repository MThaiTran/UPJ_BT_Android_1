package com.example.btnhom.repository;

import com.example.btnhom.model.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private static RoomRepository instance;
    private final List<Room> roomList;

    private RoomRepository() {
        roomList = new ArrayList<>();
        // Khởi tạo dữ liệu mẫu (Mock data)
        roomList.add(new Room("R01", "Phòng 101", 1500000, true));
        roomList.add(new Room("R02", "Phòng 102", 2000000, false));
        roomList.add(new Room("R03", "Phòng 201", 1800000, true));
    }

    public static synchronized RoomRepository getInstance() {
        if (instance == null) {
            instance = new RoomRepository();
        }
        return instance;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
